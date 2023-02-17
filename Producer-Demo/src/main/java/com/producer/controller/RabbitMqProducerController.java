package com.producer.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitMqController/")
public class RabbitMqProducerController {

        // 使用 RabbitAdmin 代替 AmqpTemplate，RabbitAdmin 有實做 initializingbean，啟動專案時會自動建立 Queue
        @Autowired
        private RabbitAdmin rabbitAdmin;

        @RequestMapping(value = "/sendMessage")
        public String sendMessage(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
                                  @RequestParam("messageData") String messageData) {
                rabbitAdmin.getRabbitTemplate().convertAndSend(exchange, routingKey, messageData);
                return "Message sent to the RabbitMQ Successfully";
        }
}
