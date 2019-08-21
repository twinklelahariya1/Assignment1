package com.gl.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "book_name")
    @Size(max = 50)
    private String  bookName;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId",nullable = false)
    private Student student;


}
