package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;
public interface IService {
    void add(Student Student);
    List<Student> delete(int id);
//    void update(Student student);
//    boolean edit(Student student);
    List<Student> getAll();


}
