package com.assignment.hrm.client.service;

import com.assignment.hrm.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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



}
