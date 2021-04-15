package com.assignment.hrm.client.model;

public class Employee {
    private Long employeeCode;
    private String employeeName;
    private String location;
    private String email;
    private String dateOfBirth;

    public Employee() {
    }

    public Employee(Long employeeCode, String employeeName, String location, String email, String dateOfBirth) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.location = location;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(Long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode=" + employeeCode +
                ", employeeName='" + employeeName + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}

