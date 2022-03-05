package com.stanleypham.feign_clients.student;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-ms", url = "${clients.student.url}")
public interface StudentClients {
    @GetMapping(value = "/student/{id}")
    StudentFeignResponse getStudentById(@PathVariable(name = "id") Integer id);

}
