package com.gl.hibernate.service;

import com.gl.hibernate.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    List<User> displayUsers();

    void deleteUser(Long userId);
}
