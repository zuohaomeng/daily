package com.meng.daily.rocketmq.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author 梦醉
 * @date 2019/11/24--17:05
 */
public interface MqProducerService {
     void sendMesDemo() throws MQClientException, Exception;
     void sendMesDefault() throws InterruptedException, RemotingException, MQClientException, MQBrokerException;
     void sendMes(String topic,String tag,String message);
}
