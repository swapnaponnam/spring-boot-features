package com.spring.springbootfeatures.service;

import com.spring.springbootfeatures.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee emp);
    Employee update(Employee emp);
    List<Employee> getEmployees();
    Employee get(Long id);

}
