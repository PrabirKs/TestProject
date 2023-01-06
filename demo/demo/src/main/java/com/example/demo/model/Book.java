package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    String name ;
    String publication ;
    String price ;
    String pages ;
    int authorId ;
    @JoinColumn
    @ManyToOne
    @JsonIgnore
    Author author ;
}
