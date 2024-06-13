package org.example.springproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Long id;
    private String author;
    private String text;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
