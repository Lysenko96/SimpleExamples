package org.example.mvcapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Long id;
    private String text;
    private String author;

    public Message(String text, String author) {
        this.text = text;
        this.author = author;
    }
}
