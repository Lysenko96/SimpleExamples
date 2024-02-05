package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "email")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(unique = true)
    String email;
    @Column(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();


    @JsonManagedReference
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Note> notes = new ArrayList<>();
    @JsonManagedReference
    @Setter(AccessLevel.PRIVATE)
    @BatchSize(size = 2) // working faster when spring.jpa.open-in-view=true get multiple fetch
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Reminder> reminders = new ArrayList<>();

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addNote(Note note) {
        note.setPerson(this);
        notes.add(note);
    }

    public void addReminder(Reminder reminder) {
        reminder.setPerson(this);
        reminders.add(reminder);
    }
}
