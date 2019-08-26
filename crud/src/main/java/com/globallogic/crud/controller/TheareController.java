package com.globallogic.crud.controller;


import com.globallogic.crud.dto.MovieDto;
import com.globallogic.crud.dto.TheatreDto;
import com.globallogic.crud.model.Movie;
import com.globallogic.crud.model.Theatre;
import com.globallogic.crud.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TheareController {

    @Autowired
    private TheatreRepository theatreRepository;

    private static MovieDto fromMovie(final Movie movie) {

        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(movie.getMovieId());
        movieDto.setMovieName(movie.getMovieName());

        return movieDto;
    }

    private static TheatreDto fromTheatre(final Theatre theatre) {

        TheatreDto theatreDto = new TheatreDto();
        theatreDto.setTheatreId(theatre.getTheatreId());
        theatreDto.setTheatreName(theatre.getTheatreName());

        return theatreDto;
    }

    private static Movie fromMovieDto(final MovieDto dto) {

        Movie movie = new Movie();
        movie.setMovieId(dto.getMovieId());
        movie.setMovieName(dto.getMovieName());

        return movie;
    }

    private static Theatre fromTheatreDto(final TheatreDto dto) {

        Theatre theatre = new Theatre();
        theatre.setTheatreId(dto.getTheatreId());
        theatre.setTheatreName(dto.getTheatreName());
        theatre.setMovies(dto.getMovies().stream().map(TheareController::fromMovieDto).collect(Collectors.toList()));

        return theatre;
    }

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatre(Theatre theatre) {
        return theatreRepository.findAll();
    }

    @PostMapping(path = "/populateTheatres", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TheatreDto> createTheatre(@RequestBody TheatreDto theatreDto) {


        Theatre savedTheatre = theatreRepository.save(fromTheatreDto(theatreDto));

        List<Movie> movies = savedTheatre.getMovies();

        List<MovieDto> collect = movies.stream().map(TheareController::fromMovie).collect(Collectors.toList());

        TheatreDto savedTheatreDto = fromTheatre(savedTheatre);

        savedTheatreDto.setMovies(collect);


        return ResponseEntity.created(null).body(savedTheatreDto);
    }
}

