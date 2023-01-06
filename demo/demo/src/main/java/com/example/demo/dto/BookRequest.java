package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookRequest {
        String name ;
        String publication ;
        String price ;
        String pages ;
        int authorId ;
}
