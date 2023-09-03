package com.example.userapp.service;

import com.example.userapp.entity.Author;
import com.example.userapp.entity.Book;
import com.example.userapp.exception.NotFoundException;
import com.example.userapp.mapper.AuthorFactory;
import com.example.userapp.mapper.AuthorMapper;
import com.example.userapp.model.dto.AuthorDto;
import com.example.userapp.repository.AuthorRepository;
import com.example.userapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.userapp.mapper.AuthorFactory.buildAuthorEntity;
import static com.example.userapp.mapper.BookMapper.buildBookEntity;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;




    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

//    public Author getAuthorById(Long authorId) {
//        return authorRepository.findBy(authorId).orElse(null);
//    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }


    public void saveAuthor(AuthorDto request){
        var author = buildAuthorEntity(request);
        var book = buildBookEntity(author, request.getName());
        authorRepository.save(author);
    }
    public AuthorDto getAuthor(Long id) {
        var author = fetchPostIfExist(id);
        return AuthorMapper.mapEntityToDto(author);
    }

    private Author fetchPostIfExist(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Error"));

    }
}
