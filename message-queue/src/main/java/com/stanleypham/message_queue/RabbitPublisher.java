package com.stanleypham.message_queue;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitPublisher {
    private final AmqpTemplate amqpTemplate;

    public void pushTemplate(Object data, String exchange, String routing) {
        log.info("{} {} {}", exchange, routing, data);
        amqpTemplate.convertAndSend(exchange, routing, data);
    }

}
