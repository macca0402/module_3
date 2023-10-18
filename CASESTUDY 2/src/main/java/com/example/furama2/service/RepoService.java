package com.example.furama2.service;

import com.example.furama2.BaseRepository.BaseRepository;
import com.example.furama2.employee.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoService implements IRepoService {

    private static final String SELECT = "SELECT * FROM dich_vu;";
    private static final String INSERT = "insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue,ma_loai_dich_vu,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang)\n" +
            "values (?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE = "delete from dich_vu where ma_dich_vu=?;";
    private static final String FIND_BY_ID = "select * from dich_vu where ma_dich_vu=?;";
    private static final String UPDATE = "update dich_vu \n" +
            "set ten_dich_vu=?,\n" +
            "dien_tich=?,chi_phi_thue=?,so_nguoi_toi_da=?,ma_kieu_thue=?,ma_loai_dich_vu=?,tieu_chuan_phong=?,\n" +
            "mo_ta_tien_nghi_khac=?,dien_tich_ho_boi=?,so_tang=?\n" +
            "where ma_dich_vu=?;";

    @Override
    public List<Service> getAll() {
        List<Service> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("ma_dich_vu");
                String name = rs.getString("ten_dich_vu");
                int area = rs.getInt("dien_tich");
                double costRent = rs.getDouble("chi_phi_thue");
                int maximumContain = rs.getInt("so_nguoi_toi_da");
                int codeTypeRent = rs.getInt("ma_kieu_thue");
                int codeTypeService = rs.getInt("ma_loai_dich_vu");
                String standardRoom = rs.getString("tieu_chuan_phong");
                String descriptionConvenience = rs.getString("mo_ta_tien_nghi_khac");
                double areaSwimmingPool = rs.getDouble("dien_tich_ho_boi");
                int numberFloor = rs.getInt("so_tang");
                Service service = new Service(code, name, area, costRent, maximumContain, codeTypeRent, codeTypeService, standardRoom, descriptionConvenience, areaSwimmingPool, numberFloor);
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Service service) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getCostRent());
            preparedStatement.setInt(4, service.getMaximumContain());
            preparedStatement.setInt(5, service.getCodeTypeRent());
            preparedStatement.setInt(6, service.getCodeTypeService());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionConvenience());
            preparedStatement.setDouble(9, service.getAreaSwimmingPool());
            preparedStatement.setInt(10, service.getNumberFloor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Service> delete(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getAll();
    }

    @Override
    public Service findByID(int id) {
        Connection connection = BaseRepository.getConnection();
        Service service = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int code = rs.getInt("ma_dich_vu");
                    String name = rs.getString("ten_dich_vu");
                    int area = rs.getInt("dien_tich");
                    double costRent = rs.getDouble("chi_phi_thue");
                    int maximumContain = rs.getInt("so_nguoi_toi_da");
                    int codeTypeRent = rs.getInt("ma_kieu_thue");
                    int codeTypeService = rs.getInt("ma_loai_dich_vu");
                    String standardRoom = rs.getString("tieu_chuan_phong");
                    String descriptionConvenience = rs.getString("mo_ta_tien_nghi_khac");
                    double areaSwimmingPool = rs.getDouble("dien_tich_ho_boi");
                    int numberFloor = rs.getInt("so_tang");
                    service = new Service(code, name, area, costRent, maximumContain, codeTypeRent, codeTypeService, standardRoom, descriptionConvenience, areaSwimmingPool, numberFloor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
        
    }

    @Override
    public List<Service> update(Service service) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getCostRent());
            preparedStatement.setInt(4, service.getMaximumContain());
            preparedStatement.setInt(5, service.getCodeTypeRent());
            preparedStatement.setInt(6, service.getCodeTypeService());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionConvenience());
            preparedStatement.setDouble(9, service.getAreaSwimmingPool());
            preparedStatement.setInt(10, service.getNumberFloor());
            preparedStatement.setInt(11,service.getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getAll();
    }
}
