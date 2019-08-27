package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.GenreDto;
import com.finalassignment.bookworm.exception.GenreNotFoundException;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.repository.GenreRepository;
import com.finalassignment.bookworm.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromGenre;
import static com.finalassignment.bookworm.util.DtoUtil.fromGenreDto;

@Service
public class GenreServiceImpl implements GenreService {


    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }




    @Override
    public GenreDto addGenre(GenreDto genreDto) {
        Genre genre = genreRepository.save(fromGenreDto(genreDto));
        return genreDto;
    }

    @Override
    public List<GenreDto> getGenre() {

        List<Genre> genres = genreRepository.findAll();
        List<GenreDto> genreDtos = null;
        if (!CollectionUtils.isEmpty(genres)) {
            genreDtos = new ArrayList<>();
            for (Genre genre : genres) {
                GenreDto genreDto = fromGenre(genre);
                genreDtos.add(genreDto);
            }
        }
        return genreDtos;
    }

    @Override
    public GenreDto findById(Long genreId) {
        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new GenreNotFoundException(genreId));
        GenreDto genreDto = fromGenre(genre);
        return genreDto;
    }
}
