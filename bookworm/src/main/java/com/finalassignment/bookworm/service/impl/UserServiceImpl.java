package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.UserDto;
import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.exception.UserNotFoundException;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.repository.UserRepository;
import com.finalassignment.bookworm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromUser;
import static com.finalassignment.bookworm.util.DtoUtil.fromUserDto;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userRepository.save(fromUserDto(userDto));
        return userDto;
    }

    @Override
    public List<UserDto> getUser() {

        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = null;
        if (!CollectionUtils.isEmpty(users)) {
            userDtos = new ArrayList<>();
            for (User user : users) {
                UserDto userDto = fromUser(user);
                userDtos.add(userDto);
            }
        }
        return userDtos;
    }

    @Override
    public UserDto findById(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        UserDto userDto = fromUser(user);
        return userDto;
    }

}
