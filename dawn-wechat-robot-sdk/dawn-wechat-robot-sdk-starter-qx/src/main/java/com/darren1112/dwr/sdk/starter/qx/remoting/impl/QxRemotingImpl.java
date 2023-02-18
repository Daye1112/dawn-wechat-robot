package com.darren1112.dwr.sdk.starter.qx.remoting.impl;

import com.alibaba.fastjson.TypeReference;
import com.darren1112.dwr.common.exception.RemotingException;
import com.darren1112.dwr.common.remoting.base.BaseRemoting;
import com.darren1112.dwr.common.util.HttpClientUtil;
import com.darren1112.dwr.common.util.StringUtil;
import com.darren1112.dwr.sdk.starter.qx.enums.ApiTypeEnum;
import com.darren1112.dwr.sdk.starter.qx.properties.QxProperties;
import com.darren1112.dwr.sdk.starter.qx.remoting.QxRemoting;
import com.darren1112.dwr.sdk.starter.qx.remoting.handler.QxRemotingHandler;
import com.darren1112.dwr.spi.qx.api.ApiListResultDto;
import com.darren1112.dwr.spi.qx.api.ApiParamDto;
import com.darren1112.dwr.spi.qx.api.result.WeChatListResult;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 千寻-客户端remotingImpl
 *
 * @author darren
 * @since 2023/2/14
 */
@Slf4j
public class QxRemotingImpl extends BaseRemoting implements QxRemoting {

    private QxProperties qxProperties;

    private HttpClientUtil httpClientUtil;

    public QxRemotingImpl(QxProperties qxProperties, HttpClientUtil httpClientUtil) {
        this.qxProperties = qxProperties;
        this.httpClientUtil = httpClientUtil;
    }

    /**
     * 获取微信列表（X0000）
     * 发送文本消息（Q0001）
     * 修改下载图片（Q0002）
     * 获取个人信息（Q0003）
     * 查询对象信息（Q0004）
     * 获取好友列表（Q0005）
     * 获取群聊列表（Q0006）
     * 获取公众号列表（Q0007）
     * 获取群成员列表（Q0008）
     * 发送聊天记录（Q0009）
     * 发送图片（Q0010）
     * 发送本地文件（Q0011）
     * 发送分享链接（Q0012）
     * 发送小程序（Q0013）
     * 发送音乐分享（Q0014）
     * 发送XML（Q0015）
     * 确认收款（Q0016）
     * 同意好友请求（Q0017）
     * 添加好友_通过v3（Q0018）
     * 添加好友_通过wxid（Q0019）
     * 查询陌生人信息（Q0020）
     * 邀请进群（Q0021）
     * 删除好友（Q0022）
     * 修改对象备注（Q0023）
     * 修改群聊名称（Q0024）
     * 发送名片（Q0025）
     *
     * @param param   请求参数
     * @param wxid    微信id
     * @param apiType api类型
     * @return {@link WeChatListResult}
     * @throws RemotingException 远程调用异常
     * @author darren
     * @since 2023/2/14
     */
    @Override
    public <T, K> ApiListResultDto<T> request(ApiParamDto<K> param, String wxid, ApiTypeEnum apiType) throws RemotingException {
        log.info("操作内容: {}", apiType.getDesc());
        String result = null;
        param.setType(apiType.getType());
        Map<String, Object> params = new HashMap<>();
        try {
            if (StringUtil.isNotBlank(wxid)) {
                params.put("wxid", wxid);
            }

            result = httpClientUtil.postJsonForJson(qxProperties.getClientUrl(), param, params);
            return super.checkSimpleResult(new QxRemotingHandler(result),
                    new TypeReference<ApiListResultDto<T>>() {
                    });
        } catch (RemotingException re) {
            throw re;
        } catch (Exception e) {
            log.error(apiType.getDesc() + "异常, result: " + result);
            throw new RemotingException(apiType.getDesc() + "异常, result: " + result);
        }
    }
}
