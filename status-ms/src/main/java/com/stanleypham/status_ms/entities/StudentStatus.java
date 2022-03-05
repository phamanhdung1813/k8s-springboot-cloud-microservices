package com.stanleypham.status_ms.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Entity
public class StudentStatus {

    @Id
    @SequenceGenerator(
            name = "status_id",
            sequenceName = "status_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "status_sequence"
    )
    private Integer id;

    private Boolean isGraduated;

    private LocalDateTime graduatedIn;

    private Double Gpa;
}
