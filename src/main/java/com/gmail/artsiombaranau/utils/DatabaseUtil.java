package com.gmail.artsiombaranau.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabaseUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/toDoList?useUnicode=true&serverTimezone=UTC", "root", "root");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Date getSQLDateFromJavaDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    public static LocalDate getJavaDateFromSQLDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }
}
