package com.example.onetoone.Repository;


import com.example.onetoone.model.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook,Long> {
}
