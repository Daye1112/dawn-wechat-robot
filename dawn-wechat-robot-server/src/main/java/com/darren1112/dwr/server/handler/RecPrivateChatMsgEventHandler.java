package com.darren1112.dwr.server.handler;

import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.common.util.HttpClientUtil;
import com.darren1112.dwr.common.util.JsonUtil;
import com.darren1112.dwr.sdk.starter.qx.base.AbstractEventHandler;
import com.darren1112.dwr.sdk.starter.qx.enums.ApiTypeEnum;
import com.darren1112.dwr.sdk.starter.qx.enums.EventTypeEnum;
import com.darren1112.dwr.sdk.starter.qx.remoting.QxRemoting;
import com.darren1112.dwr.spi.qx.api.ApiParamDto;
import com.darren1112.dwr.spi.qx.api.param.SendMsgParam;
import com.darren1112.dwr.spi.qx.event.EventDto;
import com.darren1112.dwr.spi.qx.event.data.RecPrivateChatMsgEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 收到私聊消息（10009）
 *
 * @author darren
 * @since 2023/2/15
 */
@Component
public class RecPrivateChatMsgEventHandler extends AbstractEventHandler {

    @Autowired
    private HttpClientUtil httpClientUtil;

    @Autowired
    private QxRemoting qxRemoting;

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
        EventDto<RecPrivateChatMsgEventData> event =  JsonUtil.parseObjectByObject(eventDto, new TypeReference<EventDto<RecPrivateChatMsgEventData>>(){});
        RecPrivateChatMsgEventData.SubData data = event.getData().getData();
        String fromWxid = data.getFromWxid();
        String wxid = event.getWxid();
        String msg = URLUtil.encode(data.getMsg());
        // TODO 待封装
        Map<String, Object> params = new HashMap<>();
        params.put("key", "free");
        params.put("free", 0);
        params.put("msg", msg);
        String result = httpClientUtil.getForString("http://api.qingyunke.com/api.php", params);
        JSONObject jsonObject = JsonUtil.parseObject(result, JSONObject.class);

        String content = jsonObject.getString("content");

        ApiParamDto<SendMsgParam> param = new ApiParamDto<>();
        SendMsgParam sendMsgParam = new SendMsgParam();
        sendMsgParam.setWxid(fromWxid);
        sendMsgParam.setMsg(content);
        param.setData(sendMsgParam);

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
