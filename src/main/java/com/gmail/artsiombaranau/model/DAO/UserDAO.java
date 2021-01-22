package com.gmail.artsiombaranau.model.DAO;

import com.gmail.artsiombaranau.model.entities.User;
import com.gmail.artsiombaranau.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements CRUDable<User> {

    @Override
    public boolean create(User user) {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Users (FirstName, LastName, UserName, Password) VALUES (?,?,?,?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            return !preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return false;
    }

    @Override
    public User read(int ID) throws NullPointerException {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE UserID=? ");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setID(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setUserName(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return null;
    }

    @Override
    public boolean update(int ID, String newPassword) {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE Users SET Password=? WHERE ID=?");
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, ID);
            return !preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int ID) {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE ID=?");
            preparedStatement.setInt(1, ID);
            return !preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return false;
    }

    public User checkRegistration(String userName, String password) throws NullPointerException {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE UserName=? AND Password=?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setID(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setUserName(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return null;
    }
}
