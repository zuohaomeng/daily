package com.meng.daily.rocketmq.controller;

import com.meng.daily.rocketmq.constant.ResResult;
import com.meng.daily.rocketmq.service.MqProducerService;
import com.meng.daily.rocketmq.service.OrderMqProducerService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
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
    @Resource
    private OrderMqProducerService orderMqProducerService;

    @ApiOperation("构造生产者发送消息")
    @GetMapping("/send")
    public String send() {
        try {
            mqProducerService.sendMesDemo();
        } catch (Exception e) {
            log.error("sendMesDemo error", e);
        }
        return "sendMesDemo";
    }
    @ApiOperation("默认发送消息")
    @GetMapping("/sendMqByDefault")
    public String sendMqByDefault() {
        try {
            mqProducerService.sendMesDefault();
        } catch (Exception e) {
            log.error("sendMqByDefault error",e);
        }
        return "sendMqByDefault";
    }
    @ApiOperation("同步发送消息")
    @GetMapping("/syncSendMq")
    public ResResult syncSendMq(){
        try {
            SendResult sendResult = mqProducerService.syncSendMq();
            return ResResult.success(sendResult);
        } catch (Exception e) {
            log.error("syncSendMq error",e);
        }
        return ResResult.error();
    }

    @ApiOperation("发送异步消息")
    @GetMapping("/asyncSendMq")
    public ResResult asyncSendMq(){
        try {
            mqProducerService.asyncSendMq();
        } catch (Exception e) {
            log.error("asyncSendMq error",e);
        }
        return ResResult.success("消息发送了");
    }

    @ApiOperation("单向发送消息")
    @GetMapping("/sendMqOneway")
    public ResResult sendMqOneway(){
        try {
            mqProducerService.sendMqOneway();
        } catch (Exception e) {
            log.error("asyncSendMq error",e);
        }
        return ResResult.success("消息发送了");
    }

    @GetMapping("/sendOrderMsg")
    @ApiOperation("发送顺序消息")
    public ResResult sendOrderMsg(){
        try {
            orderMqProducerService.send();
        } catch (Exception e) {
            log.error("sendOrderMsg error ",e);
        }
        return ResResult.success();
    }
    @GetMapping("/sendScheduledMsg")
    @ApiOperation("/发送延时消息")
    public ResResult sendScheduledMsg(){
        try {
            mqProducerService.sendScheduledMsg();
        } catch (Exception e) {
            log.error("sendScheduledMsg error",e);
            return ResResult.error();
        }
        return ResResult.success();
    }
    @GetMapping("/sendBatchMsg")
    @ApiOperation("发送批量消息")
    public ResResult sendBatchMsg(){
        try {
            mqProducerService.sendBatchMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ResResult.success();
    }
}
