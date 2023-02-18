package com.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumerService {

    @RabbitListener(queues = "adminQueue")
    public void recievedMessage(String message) {
        System.out.println("Recieved Message From RabbitMQ: " + message);
    }
}
