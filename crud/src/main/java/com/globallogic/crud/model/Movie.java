package com.globallogic.crud.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movie")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;

    @Column(name = "movie_name")
    @Size(max = 50)
    private String movieName;

    @ManyToMany(mappedBy = "movies")
    @JsonBackReference
    private Set<Theatre> theatres;

}
