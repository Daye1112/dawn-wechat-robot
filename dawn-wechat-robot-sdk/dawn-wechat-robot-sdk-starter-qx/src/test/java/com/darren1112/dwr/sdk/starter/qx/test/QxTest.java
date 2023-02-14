package com.darren1112.dwr.sdk.starter.qx.test;

import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.spi.qx.api.ApiListResultDto;
import com.darren1112.dwr.spi.qx.api.result.WeChatListResult;
import org.junit.Test;

/**
 * @author darren
 * @since 2023/2/14
 */
public class QxTest {

    @Test
    public void test01() {
        TypeReference<ApiListResultDto<WeChatListResult>> typeReference = new TypeReference<ApiListResultDto<WeChatListResult>>() {
        };
        System.out.println(typeReference.getType().getClass());
    }
}
