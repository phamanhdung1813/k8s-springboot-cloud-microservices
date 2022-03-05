package com.stanleypham.status_ms.repositories;

import com.stanleypham.status_ms.entities.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<StudentStatus, Integer> {
    Optional<StudentStatus> findStatusById(Integer id);
}
