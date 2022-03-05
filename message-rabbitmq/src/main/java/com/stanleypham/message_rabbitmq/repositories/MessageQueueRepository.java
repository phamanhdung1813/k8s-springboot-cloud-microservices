package com.stanleypham.message_rabbitmq.repositories;

import com.stanleypham.message_rabbitmq.entities.MessageQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageQueueRepository extends JpaRepository<MessageQueue, Integer> {
}
