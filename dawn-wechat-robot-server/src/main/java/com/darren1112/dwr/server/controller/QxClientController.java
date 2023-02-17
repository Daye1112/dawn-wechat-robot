package com.darren1112.dwr.server.controller;

import com.darren1112.dwr.sdk.starter.qx.manager.QxEventHandlerManager;
import com.darren1112.dwr.spi.qx.event.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 千寻-客户端监听器
 *
 * @author darren
 * @since 2023/2/15
 */
@RestController
public class QxClientController {

    @Autowired
    private QxEventHandlerManager qxEventHandlerManager;

    /**
     * 监听接口
     *
     * @param eventDto 监听事件
     * @author darren
     * @since 2023/2/15
     */
    @PostMapping("/listener")
    public void listener(@RequestBody EventDto eventDto) throws Exception {
        // 事件处理器
        qxEventHandlerManager.getEventHandler(eventDto.getEvent())
                .handler(eventDto);
    }
}
