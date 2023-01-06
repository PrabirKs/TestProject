package com.example.demo.converter;


import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.model.Book;
import lombok.experimental.UtilityClass;

@UtilityClass
public class  BookConverter {

    public static BookResponse entityToDto(Book book){
        BookResponse bookResponse = BookResponse.builder().bookName(book.getName()).publication(book.getPublication()).build() ;
        return bookResponse ;
    }

    public static Book dtoToEntity(BookRequest bookRequest) {
        return Book.builder().name(bookRequest.getName()).price(bookRequest.getPrice())
                .publication(bookRequest.getPublication())
                .pages(bookRequest.getPages())
                .authorId(bookRequest.getAuthorId()).build() ;
    }
}
