package com.meng.daily.rocketmq.config;

import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * 事务生产者注册
 * 事务消息共有三种状态，提交状态、回滚状态、中间状态：
 *
 * TransactionStatus.CommitTransaction: 提交事务，它允许消费者消费此消息。
 * TransactionStatus.RollbackTransaction: 回滚事务，它代表该消息将被删除，不允许被消费。
 * TransactionStatus.Unknown: 中间状态，它代表需要检查消息队列来确定状态。
 *
 *
 * 使用 TransactionMQProducer类创建生产者，并指定唯一的 ProducerGroup，就可以设置自定义线程池来处理这些检查请求。
 * 执行本地事务后、需要根据执行结果对消息队列进行回复。
 * 回传的事务状态在请参考前一节。
 *
 * @author 梦醉
 * @date 2019/12/1--14:13
 */
@Configuration
public class TransactionProducerRegistry {

    @Bean
    public TransactionMQProducer transactionMQProducer(){

        TransactionListener listener = new TransactionListenerImpl();
        TransactionMQProducer producer = new TransactionMQProducer("transactionMQProducer");
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });
        producer.setExecutorService(executorService);
        producer.setTransactionListener(listener);

        return producer;
    }
}