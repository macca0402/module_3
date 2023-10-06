package com.example.demo.repo;

import com.example.demo.model.Student;

import java.util.List;

public interface IRepo {
    void add(Student student);

    List<Student> update(Student Student);
//    void updateStudent(Student student);

    List<Student> delete(int id);

    List<Student> getAll();
}
