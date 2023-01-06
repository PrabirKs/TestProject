package com.example.demo.service;

import com.example.demo.converter.BookConverter;
import com.example.demo.dto.AuthorResponse;
import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.reository.AuthorRepository;
import com.example.demo.reository.BookRepository;
import jdk.jfr.BooleanFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository ;
    @Autowired
    AuthorRepository authorRepository ;
    //add book
    public BookResponse addBook(BookRequest bookRequest){
        Book book = BookConverter.dtoToEntity(bookRequest) ;
        book = bookRepository.save(book) ;

        int authorId = book.getAuthorId() ;
        //adding the book in the author
        Author author = authorRepository.findById(authorId).get() ;
        List<Book> books = author.getBooksWritten() ;
        books.add(book) ;
        authorRepository.save(author) ;

        return BookConverter.entityToDto(book) ;
    }

    //get book
    public BookResponse getBook(int id){
        Book book = bookRepository.findById(id).get() ;
        return BookConverter.entityToDto(book) ;
    }
}
