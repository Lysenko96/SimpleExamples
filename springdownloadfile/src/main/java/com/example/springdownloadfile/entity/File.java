package com.example.springdownloadfile.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Lob
    private Byte[] file;

    public File(String description, Byte[] image) {
        this.description = description;
        this.file = image;
    }
}
