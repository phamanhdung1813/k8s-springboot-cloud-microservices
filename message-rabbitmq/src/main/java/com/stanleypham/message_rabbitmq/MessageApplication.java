package com.stanleypham.message_rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "com.stanleypham.message_rabbitmq",
                "com.stanleypham.message_queue"
        }
)
@EnableFeignClients(basePackages = "com.stanleypham.feign_clients")
@EnableEurekaClient
@PropertySources({
        @PropertySource("classpath:application-${spring.profiles.active}.properties")
})
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }
}
