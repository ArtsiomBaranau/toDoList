package com.gmail.artsiombaranau.model.DAO;

import com.gmail.artsiombaranau.model.entities.Task;
import com.gmail.artsiombaranau.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO implements CRUDable<Task> {

    @Override
    public boolean create(Task task) {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Tasks (UserID, CreatedAt, Task) VALUES (?,?,?)");
            preparedStatement.setInt(1, task.getUserID());
            preparedStatement.setDate(2, DatabaseUtil.getSQLDateFromJavaDate(task.getCreatedAt()));
            preparedStatement.setString(3, task.getTask());
            return !preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return false;
    }

    @Override
    public Task read(int ID) {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Task task = new Task();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Tasks WHERE ID=?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                task.setID(resultSet.getInt(1));
                task.setUserID(resultSet.getInt(2));
                task.setCreatedAt(DatabaseUtil.getJavaDateFromSQLDate(resultSet.getDate(3)));
                task.setTask(resultSet.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return task;
    }

    public List<Task> readAllTasksByUserID(int userID) {
        Connection connection = DatabaseUtil.getConnection();
        ArrayList<Task> list = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Task task;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Tasks WHERE UserID=? ORDER BY CreatedAt");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                task = new Task();
                task.setID(resultSet.getInt(1));
                task.setUserID(resultSet.getInt(2));
                task.setCreatedAt(DatabaseUtil.getJavaDateFromSQLDate(resultSet.getDate(3)));
                task.setTask(resultSet.getString(4));
                list.add(task);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return list;
    }

    @Override
    public boolean update(int ID, String newText) {
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE Tasks SET Task=? WHERE ID=?");
            preparedStatement.setString(1, newText);
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
            preparedStatement = connection.prepareStatement("DELETE FROM Tasks WHERE ID=?");
            preparedStatement.setInt(1, ID);
            return !preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection();
        }
        return false;
    }
}
