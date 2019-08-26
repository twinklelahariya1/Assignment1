package com.example.onetoone.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "issue_book")
public class IssueBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueBookId;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "issue_id")
//    @JsonBackReference(value = "issue-book")
//    private Issue issue;


    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date issueDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date returnDate;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-issue-book")
    private Book books;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_card_id")
    @JsonBackReference(value = "issue-book-library-card")
    private LibraryCard libraryCard;
}
