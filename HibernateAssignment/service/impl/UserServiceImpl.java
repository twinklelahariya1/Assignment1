package com.gl.hibernate.service.impl;

import com.gl.hibernate.model.User;
import com.gl.hibernate.repository.UserRepository;
import com.gl.hibernate.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public List<User> displayUsers() {

        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);
    }


}
