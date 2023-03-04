package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Statement statement = Util.getStatement();
//        statement.execute("INSERT INTO Users(name, lastName, age) VALUES('Alex', 'Sidorov', 123 );");
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        Util.close();
    }
}