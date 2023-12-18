package com.example.springbootentitymanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "my_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToOne(mappedBy = "author")
    //@JoinColumn(name = "book_id")
    private Book book;

    public Author(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public Author(String name) {
        this.name = name;
    }
}
