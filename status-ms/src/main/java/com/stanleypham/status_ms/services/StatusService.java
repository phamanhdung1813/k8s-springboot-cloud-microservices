package com.stanleypham.status_ms.services;

import com.stanleypham.status_ms.entities.StudentStatus;
import com.stanleypham.status_ms.repositories.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Slf4j
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public StudentStatus checkStatus(StudentStatus studentStatus) {
        studentStatus.setGraduatedIn(LocalDateTime.now());
        return statusRepository.save(studentStatus);
    }

    public StudentStatus getByStatusId(Integer id) {
        return statusRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(
                        String.format("NOT FOUND ID: %d", id)
                ));
    }
}
