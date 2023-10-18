package com.example.furama2.customer;

import com.example.furama2.BaseRepository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoCustomer implements IRepoCustomer {

    private static final String SELECT = "SELECT * FROM khach_hang;";
    private static final String INSERT = "insert into khach_hang(ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi) values (?,?,?,?,?,?,?,?);";
    private static final String DELETE = " delete from khach_hang where khach_hang.ma_khach_hang=?; ";
    private static final String FIND_BY_ID = "SELECT * from khach_hang where khach_hang.ma_khach_hang=?;";
    private static final String UPDATE = "UPDATE  khach_hang\n" +
            "SET ma_loai_khach=?,ho_ten=?,ngay_sinh=?,gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=?\n" +
            "WHERE khach_hang.ma_khach_hang=?;";
    private static final String CUSTOMER = "call danh_sach_khach_hang();";

    @Override
    public void add(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setDate(3, Date.valueOf(customer.getCustomerBirthday()));
            preparedStatement.setBoolean(4, Boolean.parseBoolean(customer.getCustomerGender()));
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_khach_hang");
                int customerTypeId = rs.getInt("ma_loai_khach");
                String customerName = rs.getString("ho_ten");
                String customerBirthday = rs.getString("ngay_sinh");
                String customerGender = rs.getString("gioi_tinh");
                String customerIdCard = rs.getString("so_cmnd");
                String customerPhone = rs.getString("so_dien_thoai");
                String customerEmail = rs.getString("email");
                String customerAddress = rs.getString("dia_chi");
                Customer customer = new Customer(id, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public List<Customer> delete(int id) {
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
    public Customer findByID(int id) {
        Connection connection = BaseRepository.getConnection();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customerTypeId = rs.getInt("ma_loai_khach");
                String customerName = rs.getString("ho_ten");
                String customerBirthday = rs.getString("ngay_sinh");
                String customerGender = rs.getString("gioi_tinh");
                String customerIdCard = rs.getString("so_cmnd");
                String customerPhone = rs.getString("so_dien_thoai");
                String customerEmail = rs.getString("email");
                String customerAddress = rs.getString("dia_chi");
                customer = new Customer(id, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> update(Customer customer1) {
        Connection connection = BaseRepository.getConnection();

        try {
//            "UPDATE  khach_hang\n" +
//                    "SET ma_loai_khach=?,ho_ten=?,ngay_sinh=?,gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=?\n" +
//                    "WHERE khach_hang.ma_khach_hang=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, customer1.getCustomerTypeId());
            preparedStatement.setString(2, customer1.getCustomerName());
            preparedStatement.setDate(3, Date.valueOf(customer1.getCustomerBirthday()));
            preparedStatement.setBoolean(4, Boolean.parseBoolean(customer1.getCustomerGender()));
            preparedStatement.setString(5, customer1.getCustomerIdCard());
            preparedStatement.setString(6, customer1.getCustomerPhone());
            preparedStatement.setString(7, customer1.getCustomerEmail());
            preparedStatement.setString(8, customer1.getCustomerAddress());
            preparedStatement.setInt(9, customer1.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAll();
    }

    @Override
    public List<Customer> customerUseService() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_khach_hang");
                String nameServiceAttach=rs.getString("ten_dich_vu_di_kem");
                String name=rs.getString("ho_ten");
                Customer customer=new Customer(id,name,nameServiceAttach);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }
}
