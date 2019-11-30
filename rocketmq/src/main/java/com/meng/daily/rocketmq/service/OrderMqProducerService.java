package com.meng.daily.rocketmq.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Description: TODO 发送顺序消息
 * @Author: Hao.Zuo
 * @Date: 2019/11/30 17:30
 */
public interface OrderMqProducerService {
    /**
     * 发送顺序消息
     */
    void send() throws InterruptedException, RemotingException, MQClientException, MQBrokerException, Exception;
}
