package com.gl.hibernate.controller;


import com.gl.hibernate.model.User;
import com.gl.hibernate.service.UserService;
import com.gl.hibernate.service.impl.UserServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;


    public UserController(UserService userService) {
        this.userServiceImpl = (UserServiceImpl) userService;
    }


    @GetMapping("/showUser")
    public ResponseEntity<List> displayUser() {
        return ResponseEntity.ok(userServiceImpl.displayUsers());
    }


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User updated = userServiceImpl.addUser(user);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public HttpStatus deleteUser(@PathVariable("userId") Long userId) {
        userServiceImpl.deleteUser(userId);
        return HttpStatus.FORBIDDEN;
    }

}
