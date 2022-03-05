package com.stanleypham.status_ms.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanleypham.feign_clients.student.StudentClients;
import com.stanleypham.status_ms.entities.StudentStatus;
import com.stanleypham.status_ms.services.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/status")
@Slf4j // Logger
@RequiredArgsConstructor
public class StatusController {

    @Autowired
    private StatusService statusService;

    private final StudentClients studentClients;

    @PostMapping(value = "/save")
    public StudentStatus isGraduated(@RequestBody StudentStatus studentStatus) throws JsonProcessingException {
        log.info("Logger Status {}", new ObjectMapper().writeValueAsString(statusService));
        return statusService.checkStatus(studentStatus);
    }

    @GetMapping(value = "{id}")
    public StudentStatus getByStatusId(@PathVariable(name = "id") Integer id) {
        return statusService.getByStatusId(id);
    }
}
