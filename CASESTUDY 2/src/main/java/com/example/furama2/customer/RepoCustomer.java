package com.example.furama2.customer;

import com.example.furama2.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoCustomer implements IRepoCustomer{

    private static final String SELECT = "SELECT * FROM khach_hang;";
    private static final String INSERT = "INSERT INTO khach_hang\n" +
    "    VALUE(?,?,?,?,?,?,?,?),";

    @Override
    public void add(Customer customer) {
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,customer.getCustomerTypeId());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setString(3,customer.getCustomerBirthday());
            preparedStatement.setString(4,customer.getCustomerGender());
            preparedStatement.setString(5,customer.getCustomerIdCard());
            preparedStatement.setString(6,customer.getCustomerPhone());
            preparedStatement.setString(7,customer.getCustomerEmail());
            preparedStatement.setString(8,customer.getCustomerAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList=new ArrayList<>();
        Connection connection= BaseRepository.getConnection();

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                int id =rs.getInt("ma_khach_hang");
                int customerTypeId=rs.getInt("ma_loai_khach");
                String customerName=rs.getString("ho_ten");
                String customerBirthday=rs.getString("ngay_sinh");
                String customerGender=rs.getString("gioi_tinh");
                String customerIdCard=rs.getString("so_cmnd");
                String customerPhone=rs.getString("so_dien_thoai");
                String customerEmail=rs.getString("email");
                String customerAddress =rs.getString("dia_chi");
                Customer customer=new Customer(id,customerTypeId,customerName,customerBirthday,customerGender,customerIdCard,customerPhone,customerEmail,customerAddress);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }
}
