package com.stanleypham.student_ms.repositories;

import com.stanleypham.student_ms.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
