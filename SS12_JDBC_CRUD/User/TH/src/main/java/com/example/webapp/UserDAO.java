package com.example.webapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String URL = "jdbc:mysql://localhost:3306/demo";
    private String USERNAME = "root";
    private String PASSWORD = "0905775514";
    private static final String INSERT = "insert into users" + "(name,email,country) values(?,?,?);";
    private static final String SELECT_BY_ID = " select * from users " +
            " where users.id = ?; ";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE = "delete from users where id=?;";
    private static final String UPDATE = "update users set users.name=?,users.email=?,users.country=? where id=?;";
    private static final String SEARCH = "select * from users where users.country =?;";
    private static final String SORT = "select * from users order by users.name asc;";
    private static final String SELECT_ALL_SP="call find_all();";
   // Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
    private static final String UPDATE_SP="CALL updateInfo(?,?,?,?);";
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
    private static final String DELETE_SP="call deleteUser(?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<User> search(String COUNTRY) {
        List<User> userList=new ArrayList<>();
        User user = null;
        Connection connection = getConnection();
        Statement statement = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);

            preparedStatement.setString(1, COUNTRY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            userList.add(user);
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
        return userList;
    }

    @Override
    public List<User> sort() {
        List<User> userList=new ArrayList<>();
        User user=null;
        Connection connection=getConnection();
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(SORT);
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()){
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    String email=rs.getString("email");
                    String country=rs.getString("country");
                    user = new User(id,name,email,country);
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return userList;
    }

    @Override
    public List<User> selectAllUsers() {
//        List<User> users = new ArrayList<>();
//        Connection connection = getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
//            System.out.println(preparedStatement);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                users.add(new User(id, name, email, country));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
        List<User> list=new ArrayList<>();
        Connection connection=getConnection();
        User user;
        try {
            CallableStatement callableStatement=connection.prepareCall(SELECT_ALL_SP);
            ResultSet rs=callableStatement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country=rs.getString("country");
                user =new User(id,name,email,country);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
//        boolean rowDeleted;
//        Connection connection = getConnection();
//        PreparedStatement statement = connection.prepareStatement(DELETE);
//        statement.setInt(1, id);
//        rowDeleted = statement.executeUpdate() > 0;
//        return rowDeleted;
        boolean rowDeleted;
        Connection connection=getConnection();
        CallableStatement callableStatement=connection.prepareCall(DELETE_SP);
        callableStatement.setInt(1,id);
        rowDeleted =callableStatement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE);) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
        boolean rowUpdated;
        Connection connection =getConnection();
        CallableStatement callableStatement=connection.prepareCall(UPDATE_SP);
//        CALL updateInfo(7,"Lan","lan@gmail.com","NewYork");
        callableStatement.setInt(1,user.getId());
        callableStatement.setString(2,user.getName());
        callableStatement.setString(3, user.getEmail());
        callableStatement.setString(4, user.getCountry());
         rowUpdated = callableStatement.executeUpdate()>0;
         return rowUpdated;
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        UserDAO user =new UserDAO();
        System.out.println(user.search("VietNam"));
    }

}
