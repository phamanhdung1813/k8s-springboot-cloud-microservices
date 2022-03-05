package com.stanleypham.student_ms.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stanleypham.feign_clients.queue.QueueFeignMessage;
import com.stanleypham.message_queue.RabbitPublisher;
import com.stanleypham.message_rabbitmq.config.MessageMQConfig;
import com.stanleypham.student_ms.dto.StatusDto;
import com.stanleypham.student_ms.model.StatusResponse;
import com.stanleypham.student_ms.dto.StudentDto;
import com.stanleypham.student_ms.entities.Student;
import com.stanleypham.student_ms.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RabbitPublisher rabbitPublisher;


    private static final String STATUS_URL = "http://status-ms/status/save";

    //    @Transactional(readOnly = false,
//            isolation = Isolation.READ_COMMITTED,
//            propagation = Propagation.REQUIRED
//    )
    public StatusResponse registerNewStudent(StudentDto studentDto) throws JsonProcessingException {

        StatusDto statusDto = new StatusDto();
        statusDto.setGpa(studentDto.getGpa());
        statusDto.setIsGraduated(statusDto.getGpa() / 4 * 100 > 50);

        StatusDto statusResponse = restTemplate.postForObject(
                STATUS_URL,
                statusDto,
                StatusDto.class
        );

        // Map data from DTO to Entity
        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(studentDto, Student.class);

        // Make Return Status
        String status = Objects.requireNonNull(statusDto.getIsGraduated()) ? "GRADUATED" : "NOT GRADUATED";

        studentRepository.save(student);

        QueueFeignMessage queueFeignMessage = new QueueFeignMessage(
                student.getId(),
                String.format("Student %s is %s", student.getName(), status),
                student.getName()
        );

        rabbitPublisher.pushTemplate(
                queueFeignMessage,
                MessageMQConfig.TOPIC_EXCHANGE,
                MessageMQConfig.ROUTING_KEY
        );

        return new StatusResponse(status);
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("NOT FOUND STUDENT WITH ID: %d", id))
        );
    }
}
