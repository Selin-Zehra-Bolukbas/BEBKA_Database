package com.selin.dao;

import com.selin.user.User;

import java.util.List;

public interface UserDAO {
    void createtable();
    void save(User user);
    List<User> findAll();
    void update(User user);
    void delete(int id);
}
