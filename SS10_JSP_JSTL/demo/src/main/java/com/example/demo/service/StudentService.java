package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IService {
        StudentRepository studentRepository=new StudentRepository();
        @Override
        public void add(Student student) {
            studentRepository.add(student);

        }

        @Override
        public List<Student> delete(int id) {

            return studentRepository.delete(id);
        }

    public List<Student> update(Student student) {
        return studentRepository.update(student);
    }

//    @Override
//    public boolean edit(Student student) {
//        return studentRepository.update(student);
//    }


    @Override
        public List<Student> getAll() {
            return studentRepository.getAll();
        }

        public Student findById(int id) throws SQLException {
            return studentRepository.findById(id);

        }

}
