package com.assignment.hrm.client.controller;

import com.assignment.hrm.client.model.User;
import com.assignment.hrm.client.service.ApiServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    ApiServiceImpl apiService;

    public LoginController(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/login")
    public String formPost(@ModelAttribute("user") User user) {
        return apiService.validate(user) ? "home" : "index";
    }

}
