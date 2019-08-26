package com.globallogic.crud.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long theatreId;

    @Column(name = "theatre_Name")
    @Size(max = 50)
    private String theatreName;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "movie_theatre",
            joinColumns = @JoinColumn(name = "theatre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @JsonManagedReference
    private List<Movie> movies;
}
