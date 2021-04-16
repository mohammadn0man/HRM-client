package com.assignment.hrm.client.controller;

import com.assignment.hrm.client.model.Employee;
import com.assignment.hrm.client.service.ApiServiceImpl;
import com.assignment.hrm.client.util.UserExcelExporter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @PostMapping("/save_employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
        apiService.addEmployee(employee);
        modelMap.put("employees", apiService.findAll());
        return "home";
    }

    @GetMapping("/add_employee")
    public String addEmployee() {
        return "add_form";
    }

    @GetMapping("/download_data")
    public String downloadData(HttpServletResponse response, ModelMap modelMap) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=employees_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Employee> data = apiService.findAll();

        UserExcelExporter excelExporter = new UserExcelExporter(data);

        excelExporter.export(response);
        modelMap.put("employees", data);
        return "home";
    }

}
