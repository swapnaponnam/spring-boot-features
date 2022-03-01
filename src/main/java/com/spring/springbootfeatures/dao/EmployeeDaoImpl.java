package com.spring.springbootfeatures.dao;

import com.spring.springbootfeatures.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Employee> getEmployees() {
        return getEmployeeDetails();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return saveEmployeeDetails(employee);
    }

    public List<Employee> getEmployeeDetails() {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Employee.class);
        Root<Employee> contactRoot = criteria.from(Employee.class);
        criteria.select(contactRoot);
        return session.createQuery(criteria).getResultList();
    }
    public Employee saveEmployeeDetails(Employee emp) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        Long id  =(Long)session.save(emp);
        emp.setId(id);
        return emp;
    }
}
