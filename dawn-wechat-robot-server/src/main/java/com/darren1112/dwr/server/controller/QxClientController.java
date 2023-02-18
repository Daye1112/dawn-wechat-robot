package com.darren1112.dwr.server.controller;

import com.darren1112.dwr.common.message.JsonResult;
import com.darren1112.dwr.sdk.starter.qx.manager.QxEventHandlerManager;
import com.darren1112.dwr.spi.qx.event.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 千寻-客户端监听器
 *
 * @author darren
 * @since 2023/2/15
 */
@Slf4j
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
        log.info("event: {}", eventDto);
        // 事件处理器
        qxEventHandlerManager.getEventHandler(eventDto.getEvent())
                .handler(eventDto);
    }

    @RequestMapping("/health")
    public JsonResult health() {
        return JsonResult.buildSuccessData("OK");
    }
}
