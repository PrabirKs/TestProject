package com.example.demo.converter;

import com.example.demo.dto.AuthorRequest;
import com.example.demo.dto.AuthorResponse;
import com.example.demo.model.Author;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorConverter {
    public static AuthorResponse entityToDto(Author author){
        return AuthorResponse.builder().Name(author.getName())
                .ContactNo(author.getContactNo()).build() ;
    }

    public static Author dtoToEntity(AuthorRequest authorRequest) {
        return Author.builder().age(authorRequest.getAge()).ContactNo(authorRequest.getContactNo())
                .email(authorRequest.getEmail()).name(authorRequest.getName()).build();
    }
}
