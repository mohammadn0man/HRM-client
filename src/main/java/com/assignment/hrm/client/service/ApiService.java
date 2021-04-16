package com.assignment.hrm.client.service;

import com.assignment.hrm.client.model.Employee;
import com.assignment.hrm.client.model.User;

import java.util.List;

public interface ApiService {
    boolean validate(User user);

    List<Employee> findAll();

    Employee getEmployee(String employeeCode);

    Employee editEmployee(Employee employee);

    Employee addEmployee(Employee employee);
}
