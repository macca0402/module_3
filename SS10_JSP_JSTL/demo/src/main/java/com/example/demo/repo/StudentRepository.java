package com.example.demo.repo;

import com.example.demo.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.repo.BaseRepository.getConnection;

public class StudentRepository implements IRepo {
    private static final String SELECT_ALL_STUDENT = "select * from student;";
    private static final String UPDATE = "update student set student.name=?,student.gender=?,student.point=? where student.id=?;";
    private static final String FIND_BY_ID ="select * from student where id=?;" ;
    private static final String INSERT = "INSERT into student(name,gender,point) values (?,?,?);";
    private static final String DELETE ="delete from student where student.id=?;" ;

    @Override
    public void add(Student student) {
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT);
//            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Student findById(int id) throws SQLException {
        Student student=null;
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setInt(1,id);
        ResultSet rs=preparedStatement.executeQuery();
        while(rs.next()){
            String name=rs.getString("name");
            boolean gender=rs.getBoolean("gender");
            float point=rs.getFloat("point");
            student=new Student(id,name,gender,point);
        }
        return student;
    }
    @Override
    public List<Student> update(Student student){
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.setInt(4,student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getAll();
    }

//    @Override
//    public boolean update(Student student) {
//        boolean rowUpdate = false;
//        Connection connection = BaseRepository.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
//            preparedStatement.setString(1,student.getName());
//            preparedStatement.setBoolean(2,student.isGender());
//            preparedStatement.setFloat(3,student.getPoint());
//            preparedStatement.setInt(4,student.getId());
//            rowUpdate=preparedStatement.executeUpdate()>0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rowUpdate;
//    }


    @Override
    public List<Student> delete(int id) {
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getAll();
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Student student;
        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_STUDENT);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                float point = rs.getFloat("point");
                student = new Student(id, name, gender, point);
                studentList.add(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }
}
