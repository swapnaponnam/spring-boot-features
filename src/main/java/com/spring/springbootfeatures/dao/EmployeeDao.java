package com.spring.springbootfeatures.dao;

import com.spring.springbootfeatures.pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getEmployees();
    public Employee saveEmployee(Employee employee);
}
