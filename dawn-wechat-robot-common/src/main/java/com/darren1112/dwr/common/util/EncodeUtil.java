package com.darren1112.dwr.common.util;

import com.darren1112.dwr.common.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Objects;

/**
 * 编码格式工具类
 *
 * @author darren
 * @since 2020/3/14 14:07
 */
@Slf4j
public class EncodeUtil {

    private static final String APP_ENCODING = "UTF-8";

    private static final String DB_ENCODING = "UTF-8";

    /**
     * 根据应用的字符集对字符串进行URL编码
     */
    public static String encodeURL(Object object) {
        if (object == null) {
            return "";
        }
        try {
            return URLEncoder.encode(object.toString(), APP_ENCODING);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
            throw new BadRequestException(e.getMessage());
        }
    }

    /**
     * 根据应用的字符集对字符串进行URL解码
     */
    public static String decodeURL(Object object) {
        if (object == null) {
            return "";
        }
        try {
            return URLDecoder.decode(object.toString(), APP_ENCODING);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
            throw new BadRequestException(e.getMessage());
        }
    }

    /**
     * base64 URL Encode
     * @param object
     * @return
     * @author darren
     * @since 2020/8/31 9:29
     */
    public static String base64URLEncode(Object object){
        if(Objects.isNull(object)){
            return "";
        }
        try{
            return Base64.getUrlEncoder().encodeToString(object.toString().getBytes());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BadRequestException(e.getMessage());
        }
    }
}
