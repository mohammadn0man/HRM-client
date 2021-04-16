package com.assignment.hrm.client.controller;

import com.assignment.hrm.client.model.Employee;
import com.assignment.hrm.client.service.ApiServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    ApiServiceImpl apiService;

    public HomeController(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/edit_form")
    public String editEmployee(@RequestParam("employeeCode") String employeeCode,
                               ModelMap modelMap) {
        Employee employee = apiService.getEmployee(employeeCode);
        modelMap.put("employee", employee);
        return "edit";
    }

    @PostMapping("/save_changes")
    public String saveChanges(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
        System.out.println(employee);
        apiService.editEmployee(employee);
        modelMap.put("employees", apiService.findAll());
        return "home";
    }

}
