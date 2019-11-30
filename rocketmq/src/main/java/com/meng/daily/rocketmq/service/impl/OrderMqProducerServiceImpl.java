package com.meng.daily.rocketmq.service.impl;

import com.meng.daily.rocketmq.bean.OrderStep;
import com.meng.daily.rocketmq.constant.MQConstant;
import com.meng.daily.rocketmq.service.OrderMqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO 顺序消息
 * @Author: Hao.Zuo
 * @Date: 2019/11/30 17:31
 */
@Slf4j
@Service
public class OrderMqProducerServiceImpl implements OrderMqProducerService {
    @Resource
    private DefaultMQProducer producer;
    @Override
    public void send() throws Exception {
        String[] tags = new String[]{"TagA", "TagC", "TagD"};
        //获取订单列表
        List<OrderStep> list = new OrderStep().buildOrders();


        for (int i = 0; i < list.size(); i++) {
            String body = "hello OrderMessage " + list.get(i);
            Message message =new Message(MQConstant.DEMO_TIPIC,tags[i%tags.length],"KEY"+i,body.getBytes());
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    long id = (Long) o;
                    MessageQueue queue = list.get((int) (id % list.size()));
                    return queue;
                }
            }, list.get(i).getOrderId());
            log.info("sendResult={},queueId{},orderid={}",sendResult,sendResult.getMessageQueue().getQueueId(),list.get(i).getOrderId());
        }
    }
}
