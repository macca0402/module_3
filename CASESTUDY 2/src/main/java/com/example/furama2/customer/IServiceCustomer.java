package com.example.furama2.customer;

import java.util.List;

public interface IServiceCustomer {
    void add(Customer customer);
    List<Customer> getAll();

    List<Customer> delete(int id);

    Customer findByID(int id);
    List<Customer> customerUseService();
    List<Customer> update(Customer customer);
}
