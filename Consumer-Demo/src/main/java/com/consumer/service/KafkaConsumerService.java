package com.consumer.service;

import com.consumer.config.KafkaConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = KafkaConfig.JSON_TOPIC, groupId = KafkaConfig.GROUP_1,
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Recieved Message From Kafka Group_1 : " + message);
    }


    @KafkaListener(topics = KafkaConfig.JSON_TOPIC, groupId = KafkaConfig.GROUP_2,
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(String message) throws InterruptedException {
        System.out.println("Recieved Message From Kafka Group_2 : " + message);
    }
}
