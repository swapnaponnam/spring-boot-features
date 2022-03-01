package com.spring.springbootfeatures.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "dept")
  private List<Employee> employee;

  // getters and setters goes here
}
