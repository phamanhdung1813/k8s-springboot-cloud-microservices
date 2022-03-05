package com.stanleypham.feign_clients.student;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentFeignResponse {
    private String name;
    private Double gpa;
}
