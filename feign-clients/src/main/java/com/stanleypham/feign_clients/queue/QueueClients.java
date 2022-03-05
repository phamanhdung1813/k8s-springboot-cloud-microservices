package com.stanleypham.feign_clients.queue;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "message-rabbitmq",
        url = "${clients.messagemq.url}"
)
public interface QueueClients {
    @PostMapping(value = "/message-rabbitmq")
    void sendMessage(QueueFeignMessage queueFeignMessage);
}
