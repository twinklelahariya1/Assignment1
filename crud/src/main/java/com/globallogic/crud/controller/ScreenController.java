package com.globallogic.crud.controller;

import com.globallogic.crud.model.Screen;
import com.globallogic.crud.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScreenController {


    @Autowired
    private ScreenRepository screenRepository;

    @GetMapping("/screens")
    public List<Screen> getAllScreens(Screen screen){
        return  screenRepository.findAll();

    }


    @PostMapping("/populateScreens")
    public Screen createSeats(@RequestBody Screen screen){
        return  screenRepository.save(screen);
    }
}
