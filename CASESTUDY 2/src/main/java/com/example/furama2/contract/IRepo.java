package com.example.furama2.contract;

import com.example.furama2.customer.Customer;

import java.util.List;

public interface IRepo {
    List<Contract> findAll();
    void add(Contract contract);
    List<ContractDetail> findAllDetail();
    void add(ContractDetail contractDetail);

}
