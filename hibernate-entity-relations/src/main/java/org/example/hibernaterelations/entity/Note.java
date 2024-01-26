package org.example.hibernaterelations.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "note")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @ToString.Exclude
    @ManyToOne(optional = false) // person_id not null
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "note_person_fk"))
    private Person person;

    public Note(String body) {
        this.body = body;
    }
}
