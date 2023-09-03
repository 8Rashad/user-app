package com.example.userapp.mapper;

import com.example.userapp.entity.Author;
import com.example.userapp.model.dto.AuthorDto;

public class AuthorFactory {
    public static Author buildAuthorEntity(AuthorDto dto){
        return Author.builder()
                .name(dto.getName())
                .build();
    }
}
