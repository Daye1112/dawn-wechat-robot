package com.darren1112.dwr.common.util;

import cn.hutool.core.date.DateUtil;
import com.darren1112.dwr.common.constants.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 *
 * @author darren
 * @since 2020/3/14 12:16
 */
@Slf4j
public class HttpClientUtil {

    /**
     * 默认30000毫秒
     */
    private final static int SOCKET_TIMEOUT = 30000;

    /**
     * 默认30000毫秒
     */
    private final static int CONNECT_TIMEOUT = 30000;

    /**
     * 连接池，最大连接数
     */
    private final static int POOL_MAX_TOTAL = 600;

    /**
     * 每个路由最大连接数，即每个host的最大连接数
     */
    private final static int POOL_MAX_PER_ROUTE = 300;

    private List<HttpRequestInterceptor> requestInterceptorList = new ArrayList<>();

    private List<HttpResponseInterceptor> responseInterceptorList = new ArrayList<>();

    private HttpClientBuilder builder;

    private CloseableHttpClient httpclient;

    public HttpClientUtil() {
        this.init();
    }

    public String getForString(String uri, Map<String, Object> params) {
        String getUrl = HttpUtil.makeGetQuery(uri, params);
        return getForString(getUrl, CommonConstant.CHARSET, null);
    }

    /**
     * get请求
     *
     * @param uri 请求路径
     */
    public String getForString(String uri) {
        return getForString(uri, "UTF-8", null);
    }

    public String getForString(String uri, String charSet, Map<String, String> headers) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet get = new HttpGet(uri);
        try {
            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> current : headers.entrySet()) {
                    get.addHeader(current.getKey(), current.getValue());
                }
            }

            httpClient = getHttpClient(uri);
            response = execute(httpClient, get);
            if (response != null) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity, charSet);
                    log.info("url: {}, method: GET: {}, result: {}", uri, result);
                    return result;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            abort(get);
            close(response);
        }
        return null;
    }

    public String postForJson(String uri, Map<String, Object> params) {
        return postForJson(uri, params, "UTF-8");
    }

    public String postForJson(String uri, Map<String, Object> params, String charset) {
        return postForJson(uri, params, charset, null);
    }

    public String postForJson(String uri, Map<String, Object> params, String charset,
                              Map<String, String> headers) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(uri);
        List<BasicNameValuePair> nvp = new ArrayList<>();

        if (null != params && !params.isEmpty()) {
            for (Map.Entry<String, Object> current : params.entrySet()) {
                String value = null;
                if (current.getValue() != null && current.getValue() instanceof Date) {
                    value = DateUtil.format((Date) current.getValue(), "yyyy-MM-dd HH:mm:ss.SSS");
                } else {
                    value = current.getValue() == null ? "" : current.getValue().toString();
                }
                nvp.add(new BasicNameValuePair(current.getKey(), value));
            }
        }

        if (null != headers && !headers.isEmpty()) {
            for (Map.Entry<String, String> current : headers.entrySet()) {
                post.addHeader(current.getKey(), current.getValue());
            }
        }

        try {
            httpClient = getHttpClient(uri);
            post.setEntity(new UrlEncodedFormEntity(nvp, "UTF-8"));
            response = execute(httpClient, post);
            if (response != null) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity, charset);
                    if (log.isDebugEnabled()) {
                        log.debug("get, uri = " + uri + ", result = " + result);
                    }
                    return result;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            abort(post);
            close(response);
        }
        return null;
    }

    public byte[] getForBinary(String url) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet get = new HttpGet(url);
        byte[] result = null;
        try {
            get.setHeader("Content-Type", "application/octet-stream");
            httpClient = getHttpClient(url);
            response = execute(httpClient, get);
            if (response != null) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream content = entity.getContent();
                    result = EntityUtils.toByteArray(entity);

                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            abort(get);
            close(response);
        }
        return result;
    }

    /**
     * json格式的post请求
     *
     * @param url    接口
     * @param object 对象
     * @return {@link String}
     * @author darren
     * @since 2023/2/13
     */
    public String postJsonForJson(String url, Object object) {
        return postJsonForJson(url, object, CommonConstant.CHARSET, null, null);
    }

    /**
     * json格式的post请求
     *
     * @param url    接口
     * @param object 对象
     * @param params url参数
     * @return {@link String}
     * @author darren
     * @since 2023/2/13
     */
    public String postJsonForJson(String url, Object object, Map<String, Object> params) {
        return postJsonForJson(url, object, CommonConstant.CHARSET, params, null);
    }

    /**
     * json格式的post请求
     *
     * @param url     接口
     * @param object  对象
     * @param params  url参数
     * @param headers 请求头
     * @return {@link String}
     * @author darren
     * @since 2023/2/13
     */
    public String postJsonForJson(String url, Object object, Map<String, Object> params, Map<String, String> headers) {
        return postJsonForJson(url, object, CommonConstant.CHARSET, params, headers);
    }

    /**
     * json格式的post请求
     *
     * @param url     接口
     * @param object  对象
     * @param charset 编码
     * @param params  url参数
     * @param headers 请求头
     * @return {@link String}
     * @author darren
     * @since 2023/2/13
     */
    public String postJsonForJson(String url, Object object, String charset, Map<String, Object> params, Map<String, String> headers) {
        String fullUrl = MapUtil.isEmpty(params) ? url : HttpUtil.makeGetQuery(url, params);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(fullUrl);
        // 请求头加载
        if (MapUtil.isNotEmpty(headers)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                post.addHeader(header.getKey(), header.getValue());
            }
        }
        post.addHeader("Content-Type", "application/json");
        // 请求体转换
        String jsonBody = JsonUtil.toJsonString(object);
        post.setEntity(new StringEntity(jsonBody, charset));
        try {
            httpClient = getHttpClient(url);
            response = execute(httpClient, post);
            if (response != null) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity, charset);
                    log.info("url: {}, method: POST, json: {}, result: {}", fullUrl, jsonBody, result);
                    return result;
                }
            }
        } catch (Exception e) {
            log.error("url: " + fullUrl + ", method: POST, json: " + jsonBody, e);
        } finally {
            abort(post);
            close(response);
        }
        return null;
    }

    private CloseableHttpResponse execute(CloseableHttpClient client, HttpRequestBase base) {
        //设置超时时间
        setTimeout(base);
        try {
            CloseableHttpResponse response = client.execute(base);
            int status = response.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                return response;
            } else {
                //错误的响应码
                URI uri = base.getURI();
                if (null != uri) {
                    log.error("HOST:{}, PORT:{}, PATH:{}, STATUS:{}", uri.getHost(), uri.getPort(), uri.getPath(), status);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private void setTimeout(HttpRequestBase base) {
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .build();
        base.setConfig(config);
    }

    private CloseableHttpClient getHttpClient(String uri) {
        if (StringUtil.isEmpty(uri)) {
            return null;
        }
        return httpclient;
    }

    private void close(CloseableHttpResponse response) {
        try {
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            log.error("HttpResponse关闭失败!", e);
        }
    }

    private void close(CloseableHttpClient client) {
        try {
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            log.error("client关闭失败!", e);
        }
    }

    private void abort(HttpRequestBase request) {
        try {
            if (request != null) {
                request.abort();
            }
        } catch (Exception e) {
            log.error("HttpRequestBase关闭失败!", e);
        }
    }

    public List<HttpRequestInterceptor> getRequestInterceptorList() {
        return requestInterceptorList;
    }

    public void setRequestInterceptorList(List<HttpRequestInterceptor> requestInterceptorList) {
        this.requestInterceptorList = requestInterceptorList;
    }

    public List<HttpResponseInterceptor> getResponseInterceptorList() {
        return responseInterceptorList;
    }

    public void setResponseInterceptorList(List<HttpResponseInterceptor> responseInterceptorList) {
        this.responseInterceptorList = responseInterceptorList;
    }

    public void addRequestInterceptorList(HttpRequestInterceptor httpRequestInterceptor) {
        this.requestInterceptorList.add(httpRequestInterceptor);
    }

    public void addResponseInterceptorList(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptorList.add(httpResponseInterceptor);
    }

    public void init() {
        SSLContext sslContext = null;

        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            //加载客户端证书
            keyStore.load(null, null);
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                /**
                 * 信任所有，忽略对服务端的证书验证
                 */
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | KeyManagementException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("http client init error");
        }
        // ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名证明器基本上是关闭主机名验证，实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException一场
        SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"},
                        null, SSLConnectionSocketFactory.getDefaultHostnameVerifier()
                );
        //初始化连接池
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(POOL_MAX_TOTAL);
        cm.setDefaultMaxPerRoute(POOL_MAX_PER_ROUTE);

        this.builder = HttpClients.custom().setConnectionManager(cm).setSSLSocketFactory(sslConnectionSocketFactory);
        fillRequestInterceptors(builder);
        fillResponseInterceptors(builder);

        httpclient = builder.build();
    }

    private void fillResponseInterceptors(HttpClientBuilder builder) {
        if (CollectionUtils.isEmpty(requestInterceptorList)) {
            return;
        }
        for (HttpResponseInterceptor httpResponseInterceptor : responseInterceptorList) {
            builder.addInterceptorLast(httpResponseInterceptor);
        }
    }

    private void fillRequestInterceptors(HttpClientBuilder builder) {
        if (CollectionUtils.isEmpty(requestInterceptorList)) {
            return;
        }
        for (HttpRequestInterceptor httpRequestInterceptor : requestInterceptorList) {
            builder.addInterceptorLast(httpRequestInterceptor);
        }
    }
}
