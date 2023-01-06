package com.example.demo.controller;

import com.example.demo.converter.AuthorConverter;
import com.example.demo.dto.AuthorRequest;
import com.example.demo.dto.AuthorResponse;
import com.example.demo.dto.BookResponse;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService ;
    @PostMapping("/add")
    public AuthorResponse addAuthor(@RequestBody  AuthorRequest authorRequest){
      AuthorResponse authorResponse =  authorService.addAuthor(authorRequest) ;
      return authorResponse ;
    }
    @GetMapping("/get/{id}")
    public AuthorResponse getAuthor(@PathVariable int id){
        return authorService.getAuthor(id) ;
    }
    @GetMapping("/get/{id}")
    public List<BookResponse> getBooks(@PathVariable int id){
        List<BookResponse> books = authorService.getAllBooks(id) ;
        return books ;
    }
}
