package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/pp1";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";
    private static Connection connection;
    private static Statement statement;

    public static Statement getStatement() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    public static void close() throws SQLException {
        connection.close();
        statement.close();
    }
}
