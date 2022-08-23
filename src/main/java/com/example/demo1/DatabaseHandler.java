package com.example.demo1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DatabaseHandler {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localhost/myapp";
        String username = "root";
        String password = "12345";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, username, password);
        System.out.println("Connection to MYAPP DB succesfull!");
        return dbConnection;
    }

    public void signupUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME
                + "," + Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + "," + Const.USERS_REGION + "," +
                Const.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";
try {
    PreparedStatement prst = getDbConnection().prepareStatement(insert);
    prst.setString(1, user.getFirstname());
    prst.setString(2, user.getLastname());
    prst.setString(3, user.getLogin());
    prst.setString(4, user.getPassword());
    prst.setString(5, user.getRegion());
    prst.setString(6, user.getGender());

    prst.executeUpdate();
}
catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Connection failed...");
} catch (ClassNotFoundException e) {
    throw new RuntimeException(e);
}
    }
    public ResultSet getUser(User user) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, user.getLogin());
            prst.setString(2, user.getPassword());

            resultSet=prst.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
       return resultSet;
    }
}
