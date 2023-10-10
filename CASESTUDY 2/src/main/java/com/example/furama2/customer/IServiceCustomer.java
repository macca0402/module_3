package com.example.furama2.customer;

import java.util.List;

public interface IServiceCustomer {
    void add(Customer customer);
    List<Customer> getAll();
}
