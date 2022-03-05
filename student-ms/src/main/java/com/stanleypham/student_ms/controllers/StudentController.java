package com.stanleypham.student_ms.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stanleypham.feign_clients.status.StatusClients;
import com.stanleypham.feign_clients.status.StatusFeignResponse;
import com.stanleypham.student_ms.dto.StudentDto;
import com.stanleypham.student_ms.entities.Student;
import com.stanleypham.student_ms.model.StatusResponse;
import com.stanleypham.student_ms.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/student")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private StudentService studentService;

    private final StatusClients statusClients;

    @PostMapping
    public StatusResponse registerNewStudent(@RequestBody StudentDto request) throws JsonProcessingException {
        log.info("Created Object {}", request);
        return studentService.registerNewStudent(request);
    }

    @GetMapping(value = "{id}")
    public Student getByid(
            @PathVariable(name = "id") Integer id
    ) {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/feign/status/{id}")
    public StatusFeignResponse getStatusById(@PathVariable(name = "id") Integer id) {
        return statusClients.getStatusById(id);
    }
}
