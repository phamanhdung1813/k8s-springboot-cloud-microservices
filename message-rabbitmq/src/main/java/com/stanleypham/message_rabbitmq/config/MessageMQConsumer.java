package com.stanleypham.message_rabbitmq.config;

import com.stanleypham.feign_clients.queue.QueueFeignMessage;
import com.stanleypham.message_rabbitmq.services.MessageQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageMQConsumer {
    private final MessageQueueService service;

    // Digest the message on from the message queue
    @RabbitListener(queues = MessageMQConfig.QUEUE)
    public void messageConsumer(QueueFeignMessage feignResponse) {
        System.out.println(feignResponse);
        service.sendMessage(feignResponse);
    }
}
