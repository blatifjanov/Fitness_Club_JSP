package com.company.dao.user;

import com.company.model.User;

import java.util.List;

public interface UserDAO {
    List<User> userList();
    List<User> trainerList();
    User findById(Integer id);
    User update(User user);
    boolean delete(Integer id);
}
