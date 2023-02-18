package com.darren1112.dwr.common.util;

import com.darren1112.dwr.common.constants.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @author darren
 * @since 2020/4/11 16:48
 */
@Slf4j
public class HttpUtil {

    public static String makeGetQuery(String url, Map<String, Object> params) {
        return makeGetQuery(url, params, CommonConstant.CHARSET);
    }

    private static String makeGetQuery(String url, Map<String, Object> params, String charset) {
        String query = makeQueryString(params, charset);
        return StringUtils.join(url, "?", query);
    }

    private static String makeQueryString(Map<String, Object> params, String charset) {
        if (CollectionUtils.isEmpty(params)) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        boolean hasParam = false;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue().toString();
            if (StringUtil.isEmpty(name)) {
                continue;
            }
            if (hasParam) {
                query.append("&");
            } else {
                hasParam = true;
            }
            query.append(name).append("=").append(EncodeUtil.encodeURL(value));
        }
        return query.toString();
    }
}
