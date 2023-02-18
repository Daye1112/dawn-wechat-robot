package com.darren1112.dwr.server.handler;

import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.common.util.JsonUtil;
import com.darren1112.dwr.sdk.starter.api.remoting.OpenApiRemoting;
import com.darren1112.dwr.sdk.starter.qx.base.AbstractEventHandler;
import com.darren1112.dwr.sdk.starter.qx.enums.ApiTypeEnum;
import com.darren1112.dwr.sdk.starter.qx.enums.EventTypeEnum;
import com.darren1112.dwr.sdk.starter.qx.remoting.QxRemoting;
import com.darren1112.dwr.spi.openapi.param.QingYunKeParamDto;
import com.darren1112.dwr.spi.openapi.result.QingYunKeResultDto;
import com.darren1112.dwr.spi.qx.api.ApiParamDto;
import com.darren1112.dwr.spi.qx.api.param.SendMsgParam;
import com.darren1112.dwr.spi.qx.event.EventDto;
import com.darren1112.dwr.spi.qx.event.data.RecPrivateChatMsgEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 收到私聊消息（10009）
 *
 * @author darren
 * @since 2023/2/15
 */
@Component
public class RecPrivateChatMsgEventHandler extends AbstractEventHandler {

    @Autowired
    private QxRemoting qxRemoting;

    @Autowired
    private OpenApiRemoting openApiRemoting;

    /**
     * 处理方法
     *
     * @param eventDto 事件信息
     * @throws Exception 异常
     * @author darren
     * @since 2023/02/12
     */
    @Override
    @SuppressWarnings("unchecked")
    public void handler(EventDto eventDto) throws Exception {
        EventDto<RecPrivateChatMsgEventData> event = JsonUtil.parseObjectByObject(eventDto, new TypeReference<EventDto<RecPrivateChatMsgEventData>>() {
        });
        RecPrivateChatMsgEventData.SubData data = event.getData().getData();
        String fromWxid = data.getFromWxid();
        String wxid = event.getWxid();
        String msg = URLUtil.encode(data.getMsg());
        // 请求openApi
        QingYunKeParamDto openApiparam = new QingYunKeParamDto()
                .setMsg(msg);
        QingYunKeResultDto openApiResult = openApiRemoting.requestQingYunKeOpenApi(openApiparam);

        String content = openApiResult.getContent().replaceAll("\\{br}", "\n");

        ApiParamDto<SendMsgParam> param = new ApiParamDto<>();
        param.setData(new SendMsgParam()
                .setWxid(fromWxid)
                .setMsg(content));

        qxRemoting.request(param, wxid, ApiTypeEnum.SEND_MSG);
    }

    /**
     * 获取事件类型
     *
     * @return {@link EventTypeEnum}
     * @author darren
     * @since 2023/02/12
     */
    @Override
    public EventTypeEnum eventType() {
        return EventTypeEnum.RecPrivateChatMsgEvent;
    }
}
