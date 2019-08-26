package com.globallogic.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TheatreDto {

    private Long theatreId;

    private String theatreName;

    private List<MovieDto> movies;
}
