package com.example.demo.controller;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class BookController {
    @Autowired
    BookService bookService ;

    @PostMapping("/add")
    public BookResponse addBook(@RequestBody BookRequest bookRequest){
        BookResponse bookResponse = bookService.addBook(bookRequest) ;
        return bookResponse ;
    }

    @GetMapping("/get/{id}")
    public BookResponse getBook(@PathVariable int id){
        BookResponse bookResponse = bookService.getBook(id) ;
        return bookResponse ;
    }
}
