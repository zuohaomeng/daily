package com.meng.daily.rocketmq.service.impl;

import com.meng.daily.rocketmq.constant.MQConstant;
import com.meng.daily.rocketmq.service.MqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author 梦醉
 * @date 2019/11/24--15:53
 */
@Service
@Slf4j
public class MqProducerServiceImpl implements MqProducerService {
    @Value("${virtual.ip}")
    private String IP;

    private static final String TOPIC = MQConstant.DEMO_TIPIC;
    @Resource
    private DefaultMQProducer mqProducer;

    private int count =0;
    /**
     * 发送默认消息
     */
    @Override
    public void sendMesDefault() throws Exception {
        String msg = "demo msg test";
        log.info("开始发送消息：" + msg);
        Message sendMsg = new Message("DemoTopic", "DemoTag", msg.getBytes());
        //默认3秒超时
        SendResult sendResult = mqProducer.send(sendMsg);
        log.info("消息发送响应信息：" + sendResult.toString());
    }

    @Override
    public void sendMesDemo() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr(IP + ":9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message(TOPIC, "TagA",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }

    /**
     * 同步发送消息
     *
     * @throws Exception
     */
    @Override
    public SendResult syncSendMq() throws Exception {
        //构建消息
        Message message = new Message(TOPIC, "Taga", ("syncSendMq "+count).getBytes());
        //发送消息给broker
        SendResult send = mqProducer.send(message);

        log.info("sendResult info ={}",send.toString());
        return  send;
    }
    /**
     * 发送异步消息
     * 异步消息通常用在对响应时间敏感的业务场景，即发送端不能容忍长时间地等待Broker的响应。
     */
    @Override
    public void asyncSendMq() throws Exception{
        //构建消息
        Message message = new Message(TOPIC, "Taga", ("asyncSendMq "+count).getBytes());
        mqProducer.send(message, new SendCallback() {
            //成功时的回调
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("消息发送成功！count={}",count,sendResult.getMsgId());
            }
            //异常时候的回调
            @Override
            public void onException(Throwable throwable) {
                log.error("消息发送失败！count={}",count,throwable);
            }
        });
    }

    /**
     * 单向发送消息
     * 这种方式主要用在不特别关心发送结果的场景，例如日志发送。
     * @throws Exception
     */
    @Override
    public void sendMqOneway() throws Exception {
        Message message = new Message(TOPIC, "Taga", ("sendMqOneway "+count).getBytes());
        //单向发送，没有任何返回
        mqProducer.sendOneway(message);
    }


}