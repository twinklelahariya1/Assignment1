package com.example.onetoone.Repository;

import com.example.onetoone.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard,Long> {
}
