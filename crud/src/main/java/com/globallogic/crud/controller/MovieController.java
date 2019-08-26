package com.globallogic.crud.controller;

import com.globallogic.crud.model.Movie;
import com.globallogic.crud.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class MovieController {


    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(Movie movie) {
        return movieRepository.findAll();
    }


    @PostMapping("/populateMovies")
    public Movie createMovies(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}
