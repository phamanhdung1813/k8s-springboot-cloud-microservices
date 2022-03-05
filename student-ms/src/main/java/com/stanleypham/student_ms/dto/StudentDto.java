package com.stanleypham.student_ms.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class StudentDto {
    private String name;
    private String email;
    private Double gpa;
}
