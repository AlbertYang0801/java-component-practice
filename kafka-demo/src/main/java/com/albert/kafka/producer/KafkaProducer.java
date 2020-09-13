package com.albert.kafka.producer;

import com.albert.kafka.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * kafka的生产者
 * 回调函数
 *
 * @author Albert
 * @date 2020/7/27 20:19
 */
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.test.topic}")
    private String TOPIC_TEST;

    /**
     * 发送消息
     *
     * @param obj
     */
    public void send(Object obj) {
        String msg = JsonUtil.toString(obj);
        log.info("准备发送到kafka的消息为：{}", msg);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(msg, obj);

        //生产者对消息发送结果的处理
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败
                log.info("生产者发送消息失败，topic:{},错误信息为:{}", TOPIC_TEST, throwable.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //发送成功
                log.info("生产者发送消息失败，topic:{},错误信息为:{}", TOPIC_TEST, stringObjectSendResult.toString());
            }
        });
    }


}