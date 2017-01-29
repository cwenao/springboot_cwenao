/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.feignserver.config;

import com.bootcwenao.feignserver.kafka.listeners.KafkaListeners;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cwenao
 * @version $Id KafkaConsumerConfig.java, v 0.1 2017-01-21 21:11 cwenao Exp $$
 */
@Configuration
@AutoConfigureAfter(KafkaProducersConfig.class)
@EnableKafka
public class KafkaConsumerConfig { //<T extends Serializable> implements Serializer<T>

    @Value("${bootcwenao.kafka.binder.brokers}")
    private String brokers;

    @Value("${bootcwenao.kafka.group}")
    private String group;


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(4);
        factory.getContainerProperties().setPollTimeout(4000);

        return factory;
    }

    @Bean
    public KafkaListeners kafkaListeners() {
        return new KafkaListeners();
    }

    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> properties = new HashMap<String, Object>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        return new DefaultKafkaConsumerFactory<String, String>(properties);

    }

}

