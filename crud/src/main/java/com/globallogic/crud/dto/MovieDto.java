package com.globallogic.crud.dto;

import com.globallogic.crud.model.Theatre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto {

    private Long movieId;

    private String movieName;

    private Set<TheatreDto> theatres;
}
