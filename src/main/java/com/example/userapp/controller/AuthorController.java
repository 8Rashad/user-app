package com.example.userapp.controller;

import com.example.userapp.model.dto.AuthorDto;
import com.example.userapp.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/app/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final LibraryService libraryService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAuthor(@RequestBody AuthorDto dto){
        libraryService.saveAuthor(dto);
    }
    @GetMapping("/{id}")
    public AuthorDto getAuthor(@PathVariable Long id) {
        return libraryService.getAuthor(id);
    }
}

