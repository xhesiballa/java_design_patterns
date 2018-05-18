package com.xhesiballa.designpatterns.model;

import java.util.List;

public interface UserDAO {
    User createUser(User user);

    User getUser(int id);

    List<User> getUsers();

    int updateUser(User user);

    int deleteUser(User user);

    void deleteUsers();

    User getUserByUserName(String userName);
}
