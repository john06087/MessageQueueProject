package com.producer.controller;

import com.producer.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafkaProducerController/")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaTemplate.send(KafkaConfig.ADMIN_TOPIC, message);
        return "Message sent to the Kafka Successfully";
    }
}
