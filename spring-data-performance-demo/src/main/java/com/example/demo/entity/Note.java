package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id") //foreignKey = @ForeignKey(name = "pk_person_note")
    private Person person;

    public Note(String body) {
        this.body = body;
    }

}
