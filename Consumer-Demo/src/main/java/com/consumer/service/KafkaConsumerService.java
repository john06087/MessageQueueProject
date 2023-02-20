package com.consumer.service;

import com.consumer.config.KafkaConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = KafkaConfig.ADMIN_TOPIC, groupId = KafkaConfig.GROUP_1)
    public void consumeA(String message) {
        System.out.println("Recieved Message From Kafka admin topic consumeA in group_1 : " + message);
    }

    @KafkaListener(topics = KafkaConfig.ADMIN_TOPIC, groupId = KafkaConfig.GROUP_1)
    public void consumeB(String message) {
        System.out.println("Recieved Message From Kafka admin topic consumeB in group_1 : " + message);
    }

    @KafkaListener(topics = KafkaConfig.ADMIN_TOPIC, groupId = KafkaConfig.GROUP_2)
    public void consumeC(String message) {
        System.out.println("Recieved Message From Kafka admin topic consumeC in group_2 : " + message);
    }
}
