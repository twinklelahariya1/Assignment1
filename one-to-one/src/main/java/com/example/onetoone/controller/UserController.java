package com.example.onetoone.controller;

import com.example.onetoone.Repository.LibraryCardRepository;
import com.example.onetoone.Repository.UserRepository;
import com.example.onetoone.exception.BookNotFoundException;
import com.example.onetoone.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final UserRepository userRepository;
    private final LibraryCardRepository issueRepository;

    public UserController(UserRepository userRepository, LibraryCardRepository issueRepository) {
        this.userRepository = userRepository;
        this.issueRepository = issueRepository;
    }

    @GetMapping("/showUsers")
    public List<User> showUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addBook(@RequestBody User user) {

        return new ResponseEntity(userRepository.save(user), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/showUser/{user_id}")
    public User getUserById(@PathVariable Long user_id) {
//        log.debug("Getting Customers By Id.");
        return userRepository.findById(user_id).orElseThrow(()-> new BookNotFoundException(user_id));
    }
}
