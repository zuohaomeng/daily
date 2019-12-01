package com.meng.daily.rocketmq.config;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 当发送半消息成功时，我们使用 executeLocalTransaction 方法来执行本地事务。它返回前一节中提到的三个事务状态之一。
 * checkLocalTranscation 方法用于检查本地事务状态，并回应消息队列的检查请求。它也是返回前一节中提到的三个事务状态之一。
 * @author 梦醉
 * @date 2019/12/1--14:05
 */
public class TransactionListenerImpl implements TransactionListener {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

    /**
     * 执行本地方法
     * @param msg   消息
     * @param arg   参数
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        int value = atomicInteger.getAndIncrement();
        int status = value%3;
        localTrans.put(msg.getTransactionId(), status);
        //告诉队列你快去调用checkLocalTransaction方法吧
        return LocalTransactionState.UNKNOW;
    }

    /**
     * 回调方法
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        Integer status = localTrans.get(msg.getTransactionId());
        if(status!=null){
            switch (status){
                case 0:
                    return LocalTransactionState.UNKNOW;
                case 1:
                    return LocalTransactionState.COMMIT_MESSAGE;
                case 2:
                    return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
