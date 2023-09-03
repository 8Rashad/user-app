package com.example.userapp.mapper;

import com.example.userapp.entity.Author;
import com.example.userapp.entity.Book;

public class BookMapper {
    public static Book buildBookEntity(Author author, String title){
        return Book.builder()
                .author(author)
                .title(title)
                .build();
    }

}
