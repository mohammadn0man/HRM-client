package com.assignment.hrm.client.service;

import com.assignment.hrm.client.model.Employee;
import com.assignment.hrm.client.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiServiceImpl {

    private final WebClient webClient;

    @Autowired
    public ApiServiceImpl(WebClient webClient) {
        this.webClient = WebClient.create("http://localhost:8082");
    }


    public boolean validate(User user) {
        return webClient.post()
                .uri("/validatehr")
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public List<Employee> findAll(){
        Mono<Object[]> response = webClient.get()
                .uri("/employees")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object[].class).log();

        Object[] objects = response.block();

        ObjectMapper mapper = new ObjectMapper();

        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Employee.class))
                .collect(Collectors.toList());
    }


}
