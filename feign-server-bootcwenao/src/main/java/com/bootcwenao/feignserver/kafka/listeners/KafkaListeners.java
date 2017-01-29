/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.feignserver.kafka.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * @author cwenao
 * @version $Id KafkaListeners.java, v 0.1 2017-01-21 21:31 cwenao Exp $$
 */
public class KafkaListeners {

    @KafkaListener(topics = {"bootcwenaoTopic"})
    public void testListener(ConsumerRecord<?, ?> record) {

        Optional<?> messages = Optional.ofNullable(record.value());

        if (messages.isPresent()) {
            Object msg = messages.get();
            System.out.println("  this is the testTopic send message: " + msg);
        }

    }

}

