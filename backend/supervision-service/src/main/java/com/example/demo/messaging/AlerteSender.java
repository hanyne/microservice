package com.example.demo.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.demo.config.RabbitMQConfig.EXCHANGE;
import static com.example.demo.config.RabbitMQConfig.ROUTING_KEY;

@Component
public class AlerteSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendAlerte(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, message);
    }
}