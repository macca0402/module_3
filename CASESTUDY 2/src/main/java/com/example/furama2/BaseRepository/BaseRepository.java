package com.example.furama2.BaseRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseRepository {
    private static final String URL="jdbc:mysql://localhost:3306/quan_ly_nghi_duong_furama";
    private static final String USERNAME="root";
    private static final String PASSWORD="0905775514";
    private BaseRepository(){

    }
    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}