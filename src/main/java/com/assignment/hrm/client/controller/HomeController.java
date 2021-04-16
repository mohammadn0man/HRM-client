package com.assignment.hrm.client.controller;

import com.assignment.hrm.client.model.Employee;
import com.assignment.hrm.client.service.ApiService;
import com.assignment.hrm.client.util.UserExcelExporter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * HomeController
 * <p>list of functions</p>
 * <p>add employee - insert new record of emplouee using addemploee api</p>
 * <p>edit employee - edit details of employee with given id</p>
 * <p>download data - download data in excel format of all employees</p>
 */
@Controller
public class HomeController {

    ApiService apiService;

    public HomeController(ApiService apiService) {
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
        //using current time to name download file
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        // creating file name
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
