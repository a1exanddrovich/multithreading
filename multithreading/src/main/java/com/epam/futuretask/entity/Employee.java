package com.epam.futuretask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id) {
        this.id = id;
    }

}
