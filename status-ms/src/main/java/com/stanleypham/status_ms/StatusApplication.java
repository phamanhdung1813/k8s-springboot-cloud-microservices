package com.stanleypham.status_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = "com.stanleypham.status_ms"
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.stanleypham.feign_clients"
)
@PropertySources({
        @PropertySource("classpath:application-${spring.profiles.active}.properties")
})
public class StatusApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatusApplication.class, args);
    }
}
