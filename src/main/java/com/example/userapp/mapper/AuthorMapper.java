package com.example.userapp.mapper;

import com.example.userapp.entity.Author;
import com.example.userapp.model.dto.AuthorDto;

public class AuthorMapper {
    public static AuthorDto mapEntityToDto(Author entity){

        return new AuthorDto(entity.getId(), entity.getName());
    }
}
