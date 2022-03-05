package com.stanleypham.feign_clients.queue;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QueueFeignMessage {
    private Integer id;
    private String message;
    private String receiverName;
}
