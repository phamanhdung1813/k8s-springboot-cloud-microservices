package com.stanleypham.student_ms.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusDto {

    private Boolean isGraduated;

    private LocalDateTime graduatedIn;

    private Double Gpa;
}
