package com.stanleypham.message_rabbitmq.controllers;

import com.stanleypham.feign_clients.queue.QueueFeignMessage;
import com.stanleypham.message_rabbitmq.services.MessageQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message-rabbitmq")
@Slf4j
public class MessageQueueController {
    @Autowired
    private MessageQueueService messageQueueService;

    @PostMapping
    public String sendMessage(@RequestBody QueueFeignMessage queueFeignMessage) {
        messageQueueService.sendMessage(queueFeignMessage);
        return "Success";
    }
}
