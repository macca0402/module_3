package com.example.furama2.customer;
import java.util.List;
public interface IRepoCustomer {
    void add(Customer customer);
    List<Customer> findAll();
}
