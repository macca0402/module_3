package com.example.furama2.service;
import com.example.furama2.employee.Employee;

import java.util.List;
public interface IService {
    List<Service> findAll();
    void add(Service service);

    List<Service> delete(int id);

    Service findByID(int id);

    List<Service> update(Service service);
}
