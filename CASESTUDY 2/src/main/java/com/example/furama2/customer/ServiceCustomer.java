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

    @Override
    public List<Customer> delete(int id) {
        return repoCustomer.delete(id);
    }

    @Override
    public Customer findByID(int id) {
        return repoCustomer.findByID(id);
    }

    @Override
    public List<Customer> customerUseService() {
        return repoCustomer.customerUseService();
    }

    @Override
    public List<Customer> update(Customer customer) {
        return repoCustomer.update(customer);
    }
}
