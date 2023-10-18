package com.example.furama2.employee;

import com.example.furama2.customer.Customer;

import java.util.List;

public interface IRepoEmployee {
    void add(Employee employee);
    List<Employee> findAll();

    List<Employee> delete(int id);

    Employee findByID(int id);

    List<Employee> update(Employee Employee);
}
