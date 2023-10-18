package com.example.furama2.employee;

import com.example.furama2.BaseRepository.BaseRepository;
import com.example.furama2.customer.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepoEmployee implements IRepoEmployee{
    private static final String SELECT = "SELECT * FROM nhan_vien;";
    private static final String INSERT = "insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) values (?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE = " delete from nhan_vien where nhan_vien.ma_nhan_vien=?; ";
    private static final String FIND_BY_ID = "SELECT * from nhan_vien where nhan_vien.ma_nhan_vien=?;";
    private static final String UPDATE = " UPDATE  nhan_vien\n " +
            " SET ho_ten=?,ngay_sinh=?,so_cmnd=?,luong=?,so_dien_thoai=?,email=?,dia_chi=?,ma_vi_tri=?,ma_trinh_do=?,ma_bo_phan=?\n " +
            " WHERE nhan_vien.ma_nhan_vien=?; ";

    @Override
    public void add(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, Date.valueOf(employee.getBirthDay()));
            preparedStatement.setString(3, employee.getCmnd());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getCodePosition());
            preparedStatement.setInt(9, employee.getCodeDegree());
            preparedStatement.setInt(10, employee.getCodeDepartment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_nhan_vien");
                String name = rs.getString("ho_ten");
                String birthDay = rs.getString("ngay_sinh");
                String cmnd = rs.getString("so_cmnd");
                double salary = rs.getDouble("luong");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int codePosition = rs.getInt("ma_vi_tri");
                int codeDegree = rs.getInt("ma_trinh_do");
                int codeDepartment = rs.getInt("ma_bo_phan");
                Employee employee = new Employee(id, name, birthDay, cmnd, salary, phone, email, address, codePosition, codeDegree, codeDepartment);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public List<Employee> delete(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAll();
    }

    @Override
    public Employee findByID(int id) {
        Connection connection = BaseRepository.getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("ho_ten");
                String birthDay = rs.getString("ngay_sinh");
                String cmnd = rs.getString("so_cmnd");
                double salary = rs.getDouble("luong");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int codePosition = rs.getInt("ma_vi_tri");
                int codeDegree = rs.getInt("ma_trinh_do");
                int codeDepartment = rs.getInt("ma_bo_phan");
                employee = new Employee(id,name, birthDay, cmnd, salary, phone, email, address, codePosition, codeDegree, codeDepartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> update(Employee employee) {
        Connection connection = BaseRepository.getConnection();
          try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, Date.valueOf(employee.getBirthDay()));
            preparedStatement.setString(3, employee.getCmnd());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getCodePosition());
            preparedStatement.setInt(9, employee.getCodeDegree());
            preparedStatement.setInt(10, employee.getCodeDepartment());
            preparedStatement.setInt(11, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAll();
    }
}
