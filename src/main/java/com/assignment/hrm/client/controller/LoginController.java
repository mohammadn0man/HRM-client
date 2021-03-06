package com.assignment.hrm.client.controller;

import com.assignment.hrm.client.model.User;
import com.assignment.hrm.client.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * LoginController
 * <p>login validation call for api</p>
 * <p>validate and retrive all data to populate view</p>
 */
@Controller
public class LoginController {

    ApiService apiService;

    public LoginController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/index")
    public String goToHome(ModelMap modelMap) {
        return "index";
    }

    @PostMapping("/login")
    public String formPost(@ModelAttribute("user") User user, ModelMap modelMap) {
        if (apiService.validate(user)) {
            modelMap.put("employees", apiService.findAll());
            return "home";
        }
        return "index";
    }

}
