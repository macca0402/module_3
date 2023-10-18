package com.example.furama2.service;

import java.util.List;

public class ServiceSer implements IService{
RepoService repoService=new RepoService();
    @Override
    public List<Service> findAll() {
        return repoService.getAll();
    }

    @Override
    public void add(Service service) {
        repoService.add(service);
    }

    @Override
    public List<Service> delete(int id) {
        return repoService.delete(id);
    }

    @Override
    public Service findByID(int id) {
        return repoService.findByID(id);
    }

    @Override
    public List<Service> update(Service service) {
        return repoService.update(service);
    }
}
