package jm.task.core.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        ResultSet resultSet = DataBase.statement.executeQuery("SELECT * FROM pp1.users");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4));
        }
        DataBase.connection.close();
        DataBase.statement.close();
    }
}
class DataBase {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/";
    public static final String USER = "root";
    public static final String PASSWORD = "12345678";
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}