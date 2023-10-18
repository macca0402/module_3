package com.example.furama2.employee;

import com.example.furama2.customer.RepoCustomer;

import java.util.List;

public class ServiceEmployee implements IServiceEmployee{
    RepoEmployee repoEmployee=new RepoEmployee();
    @Override
    public void add(Employee employee) {
        repoEmployee.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repoEmployee.findAll();
    }

    @Override
    public List<Employee> delete(int id) {
        return repoEmployee.delete(id);
    }

    @Override
    public Employee findByID(int id) {
        return repoEmployee.findByID(id);
    }

    @Override
    public List<Employee> update(Employee employee) {
        return repoEmployee.update(employee);
    }
}
