package com.meng.daily.rocketmq.controller;

import com.meng.daily.rocketmq.service.MqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 梦醉
 * @date 2019/11/24--17:03
 */
@Slf4j
@RestController()
@RequestMapping("/mq")
public class MQController {
    @Resource
    private MqProducerService mqProducerService;

    @GetMapping("/send")
    public String send() {
        try {
            mqProducerService.sendMesDemo();
        } catch (Exception e) {
            log.error("sendMesDemo error", e);
        }
        return "sendMesDemo";
    }

    @GetMapping("/sendMqByDefault")
    public String sendMqByDefault() {
        try {
            mqProducerService.sendMesDefault();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sendMqByDefault";
    }

    @GetMapping("/sendmes")
    public String sendMes(String topic, String tag, String message) {
        if (StringUtils.isEmpty(topic) || StringUtils.isEmpty(tag) || StringUtils.isEmpty(message)) {
            return "为空";
        }
        mqProducerService.sendMes(topic, tag, message);
        return "sendmes";
    }
}
