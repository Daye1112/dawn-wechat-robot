package com.darren1112.dwr.sdk.starter.web.convert;

import com.darren1112.dwr.common.util.DateUtil;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * SpringContext在String和Date时的用的转化器
 *
 * @author darren
 * @since 2020/11/29 00:33
 */
public class String2DateConverter implements Converter<String, Date> {
    @SuppressWarnings("NullableProblems")
    @Override
    public Date convert(String source) {
        return DateUtil.parseDate(source);
    }
}
