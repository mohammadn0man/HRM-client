package com.assignment.hrm.client.controller;

import com.assignment.hrm.client.model.Employee;
import com.assignment.hrm.client.model.User;
import com.assignment.hrm.client.service.ApiServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {

    ApiServiceImpl apiService;

    public LoginController(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/login")
    public String formPost(@ModelAttribute("user") User user, ModelMap modelMap) {
//        System.out.println(user);
        if(apiService.validate(user)){
            List<Employee> employees = apiService.findAll();
//            System.out.println(employees);
            modelMap.put("employees", employees);
            return "home";
        }
        return "index";
    }

}
