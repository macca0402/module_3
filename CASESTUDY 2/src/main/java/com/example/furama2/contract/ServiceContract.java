package com.example.furama2.contract;

import java.util.List;

public class ServiceContract implements IService {
    Repo repoContract = new Repo();

    @Override
    public List<Contract> getAll() {
        return repoContract.findAll();
    }

    @Override
    public void add(Contract contract) {
        repoContract.add(contract);

    }

    @Override
    public List<ContractDetail> findAllDetail() {
        return repoContract.findAllDetail();
    }

    @Override
    public void add(ContractDetail contractDetail) {
        repoContract.add(contractDetail);
    }
}
