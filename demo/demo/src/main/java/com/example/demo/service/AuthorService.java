package com.example.demo.service;

import com.example.demo.converter.AuthorConverter;
import com.example.demo.converter.BookConverter;
import com.example.demo.dto.AuthorRequest;
import com.example.demo.dto.AuthorResponse;
import com.example.demo.dto.BookResponse;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.reository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository ;
    //add
    public AuthorResponse addAuthor(AuthorRequest authorRequest){
        Author author  = AuthorConverter.dtoToEntity(authorRequest) ;
        author = authorRepository.save(author) ;
        return AuthorConverter.entityToDto(author) ;
    }
    //get
    public AuthorResponse getAuthor(int id){
        Author author = authorRepository.findById(id).get() ;
        return AuthorConverter.entityToDto(author) ;
    }
    //get All Books
    public List<BookResponse> getAllBooks(int id){
        List<Book> books = new ArrayList<>() ;

        Author author = authorRepository.findById(id).get() ;

        books = author.getBooksWritten() ;
        List<BookResponse> bookResponses = new ArrayList<>() ;
        for(Book book : books){
            BookResponse bookResponse = BookConverter.entityToDto(book) ;
            bookResponses.add(bookResponse) ;
        }
        return bookResponses ;
    }
}
