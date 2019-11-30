package com.meng.daily.rocketmq.constant;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/11/28 15:48
 */
public class MQConstant {
    /**
     * demo_tipic
     */
    public static final String DEMO_TIPIC = "DemoTopic";

    @Value("${rocketmq.consumer.namesrvAddr}")
    public static String NAMESRVADDR;

    @Value("${rocketmq.consumer.groupName}")
    private String GROUPNAME;

    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int CONSUMETHREADMIN;

    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int CONSUMETHREADMAX;

    @Value("${rocketmq.consumer.topics}")
    private String TOPICS;

    @Value("${rocketmq.consumer.consumeMessageBatchMaxSize}")
    private int CONSUMEMESSAGEBATCHMAXSIZE;
}
