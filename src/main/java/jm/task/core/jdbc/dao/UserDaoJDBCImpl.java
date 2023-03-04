package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Statement statement = Util.getStatement();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS `users` (\n" +
                    "  `idUsers` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idUsers`));\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            statement.execute("DROP TABLE IF EXISTS `users`");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            statement.execute(String.format("INSERT INTO Users(name, lastName, age) VALUES('%s', '%s', %d );", name, lastName, age));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            statement.execute(String.format("DELETE FROM `Users` WHERE `idUsers` = %d", id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList= new ArrayList<>();
        try {
            ResultSet set = statement.executeQuery("SELECT * FROM Users");
            while (set.next()) {
                User user = new User(set.getString(2), set.getString(3), set.getByte(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            statement.execute("DELETE FROM users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
