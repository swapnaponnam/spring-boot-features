package com.spring.springbootfeatures.service;

import com.spring.springbootfeatures.dao.EmployeeDao;
import com.spring.springbootfeatures.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee save(Employee emp) {
        return employeeDao.saveEmployee(emp);
    }

    @Override
    public Employee update(Employee emp) {
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public Employee get(Long id) {
        return null;
    }
}
