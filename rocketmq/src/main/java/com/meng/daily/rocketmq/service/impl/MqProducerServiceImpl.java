package com.meng.daily.rocketmq.service.impl;

import com.meng.daily.rocketmq.service.MqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 梦醉
 * @date 2019/11/24--15:53
 */
@Service
@Slf4j
public class MqProducerServiceImpl implements MqProducerService {
    @Resource
    private DefaultMQProducer mqProducer;

    @Override
    public void sendMesDefault() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        String msg = "demo msg test";
        log.info("开始发送消息：" + msg);
        Message sendMsg = new Message("DemoTopic", "DemoTag", msg.getBytes());
        //默认3秒超时
        SendResult sendResult = mqProducer.send(sendMsg);
        log.info("消息发送响应信息：" + sendResult.toString());
    }

    @Override
    public void sendMes(String topic, String tag, String message) {
        Message message1 = new Message(topic, tag, message.getBytes());
        try {
            mqProducer.send(message1);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMesDemo() throws Exception {
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("192.168.186.128:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("DemoTopic" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }
}