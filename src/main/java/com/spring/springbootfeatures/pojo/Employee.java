package com.spring.springbootfeatures.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @NotNull: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not
 * null, but it can be empty.
 * @NotEmpty: a constrained CharSequence, Collection, Map, or Array is
 * valid as long as it's not null, and its size/length is greater than zero.
 * @NotBlank: a
 * constrained String is valid as long as it's not null, and the trimmed length is greater than
 * zero.
 */
@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String empName;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department dept;

}
