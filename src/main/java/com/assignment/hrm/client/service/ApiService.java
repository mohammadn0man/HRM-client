package com.assignment.hrm.client.service;

import com.assignment.hrm.client.model.Employee;
import com.assignment.hrm.client.model.User;

import java.util.List;

/**
 * All api services
 * <p>login validation call for api validate give user in db</p>
 * <p>findAll gives data of all employees</p>
 * <p>add employee - insert new record of emplouee using addemploee api</p>
 * <p>edit employee - edit details of employee with given id</p>
 * <p>download data - download data in excel format of all employees</p>
 */
public interface ApiService {

    boolean validate(User user);

    List<Employee> findAll();

    Employee getEmployee(String employeeCode);

    Employee editEmployee(Employee employee);

    Employee addEmployee(Employee employee);
}
