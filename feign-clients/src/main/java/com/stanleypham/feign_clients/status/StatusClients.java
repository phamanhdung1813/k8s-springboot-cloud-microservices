package com.stanleypham.feign_clients.status;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "status-ms", url = "${clients.status.url}")
public interface StatusClients {

    @GetMapping(value = "/status/{id}")
    StatusFeignResponse getStatusById(@PathVariable(name = "id") Integer id);
}
