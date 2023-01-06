package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthorRequest {
    String name ;
    int age ;
    String ContactNo ;
    String email ;
}
