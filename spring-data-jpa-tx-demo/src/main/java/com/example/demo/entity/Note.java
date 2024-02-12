package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "pk_person_note"))
    private Person person;

    public Note(String body) {
        this.body = body;
    }
}
