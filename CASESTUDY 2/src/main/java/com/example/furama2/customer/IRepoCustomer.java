package com.example.furama2.customer;
import java.util.List;
public interface IRepoCustomer {
    void add(Customer customer);
    List<Customer> findAll();

    List<Customer> delete(int id);

    Customer findByID(int id);

    List<Customer> update(Customer customer);
    List<Customer> customerUseService();
}
