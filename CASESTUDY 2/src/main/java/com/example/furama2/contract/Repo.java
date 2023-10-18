package com.example.furama2.contract;

import com.example.furama2.BaseRepository.BaseRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo {
    private static final String INSERT = "insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)\n" +
            "values (?,?,?,?,?,?);";
    private static final String SELECT = "select * from hop_dong;";
    private static final String SELECT_DETAIL = "select * from hop_dong_chi_tiet;";
    private static final String INSERT_DETAIL = "insert into hop_dong_chi_tiet(ma_hop_dong,ma_dich_vu_di_kem,so_luong)\n" +
            "values(?,?,?);";

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int code =rs.getInt("ma_hop_dong");
                String start = String.valueOf(rs.getString("ngay_lam_hop_dong"));
                String end= String.valueOf(rs.getString("ngay_ket_thuc"));
                double deposit=rs.getDouble("tien_dat_coc");
                int codeEmployee=rs.getInt("ma_nhan_vien");
                int codeCustomer =rs.getInt("ma_khach_hang");
                int codeService=rs.getInt("ma_dich_vu");
                Contract contract = new Contract(code,start,end,deposit,codeEmployee,codeCustomer,codeService);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList ;
    }
    @Override
    public List<ContractDetail> findAllDetail() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DETAIL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int code =rs.getInt("ma_hop_dong_chi_tiet");
                int codeContract=rs.getInt("ma_hop_dong");
                int codeServiceAttach =rs.getInt("ma_dich_vu_di_kem");
                int quantity =rs.getInt("so_luong");

                ContractDetail contractDetail = new ContractDetail(code,codeContract,codeServiceAttach,quantity);
                contractDetailList.add(contractDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetailList ;
    }

    @Override
    public void add(ContractDetail contractDetail) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DETAIL);
            preparedStatement.setInt(1,contractDetail.getCodeContract());
            preparedStatement.setInt(2,contractDetail.getCodeServiceAttach());
            preparedStatement.setInt(3,contractDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Contract contract) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, contract.getStart());
            preparedStatement.setString(2, contract.getEnd());
            preparedStatement.setDouble(3, contract.getDeposit());
            preparedStatement.setInt(4, contract.getCodeEmployee());
            preparedStatement.setInt(5, contract.getCodeCustomer());
            preparedStatement.setInt(6, contract.getCodeService());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
