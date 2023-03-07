package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Миша", "Черешков", (byte) 123);
        service.saveUser("Леша;", "Петров", (byte) 23);
        service.saveUser("Магомед", "Мегомедов", (byte) 18);
        service.saveUser("Иван", "Иванов", (byte) 12);
        System.out.println(service.getAllUsers());
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}