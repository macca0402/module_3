package com.example.furama2.customer;

import java.util.List;

public class ServiceCustomer implements IServiceCustomer{
    RepoCustomer repoCustomer=new RepoCustomer();

    @Override
    public void add(Customer customer) {
        repoCustomer.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        return repoCustomer.findAll();
    }
}
