package com.consumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumerController {

    @RabbitListener(queues = "adminQueue")
    public void recievedMessage(String message) {
        System.out.println("Recieved Message From RabbitMQ: " + message);
    }
}
