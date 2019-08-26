package com.globallogic.crud.controller;


import com.globallogic.crud.model.Seat;
import com.globallogic.crud.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;


    @GetMapping("/seats")
    public List<Seat> getAllSeats(Seat seat) {
        return seatRepository.findAll();
    }


    @PostMapping("/populateSeats")
    public Seat createSeats(@RequestBody Seat seat) {
        return seatRepository.save(seat);
    }


}
