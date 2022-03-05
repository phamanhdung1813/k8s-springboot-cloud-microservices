package com.stanleypham.student_ms.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_id",
            sequenceName = "student_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private Double gpa;

}
