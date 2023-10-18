package com.example.furama2.contract;


import com.example.furama2.customer.Customer;

import java.util.List;

public interface IService {
    List<Contract> getAll();
    void add(Contract contract);
    List<ContractDetail> findAllDetail();
    void add(ContractDetail contractDetail);

}
