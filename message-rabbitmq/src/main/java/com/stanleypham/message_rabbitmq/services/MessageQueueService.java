package com.stanleypham.message_rabbitmq.services;

import com.stanleypham.feign_clients.queue.QueueFeignMessage;
import com.stanleypham.message_rabbitmq.entities.MessageQueue;
import com.stanleypham.message_rabbitmq.repositories.MessageQueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageQueueService {
    @Autowired
    private MessageQueueRepository queueRepository;

    public void sendMessage(QueueFeignMessage queueFeignMessage) {
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.setMessage(queueFeignMessage.getMessage());
        messageQueue.setReceiverName(queueFeignMessage.getReceiverName());
        messageQueue.setTime(LocalDateTime.now());
        queueRepository.save(messageQueue);
    }

}
