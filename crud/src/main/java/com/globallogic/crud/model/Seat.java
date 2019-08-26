package com.globallogic.crud.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screenId",nullable = false)
    private Screen screen;

}
