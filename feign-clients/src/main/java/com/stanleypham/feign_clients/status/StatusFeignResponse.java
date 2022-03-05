package com.stanleypham.feign_clients.status;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatusFeignResponse {

    private Integer id;

    private Boolean isGraduated;

    private Double Gpa;
}
