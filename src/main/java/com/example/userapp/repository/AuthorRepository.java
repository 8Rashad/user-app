package com.example.userapp.repository;

import com.example.userapp.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Query("SELECT a FROM Author a")
//@EntityGraph("author-books-graph")
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id = :authorId")
    Author findAuthorWithBooks(@Param("authorId") Long authorId);
}

