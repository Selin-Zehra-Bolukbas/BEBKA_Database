package com.selin.dao;

import com.selin.user.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAOImp implements UserDAO {

    private final Connection connection;

    public UserDAOImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createtable() {
        String sql="CREATE TABLE IF NOT EXIST users(" +
                "id SERIAL PRIMARY KEY,"+
                "name VARCHAR(50),"+
                "email VARCHAR(100))";

        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tablo oluşturuldu");
        }catch(SQLException e) {
            throw new RuntimeException("Tablo oluşturulamadı");
        }

    }

    @Override
    public void save(User user) {

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
