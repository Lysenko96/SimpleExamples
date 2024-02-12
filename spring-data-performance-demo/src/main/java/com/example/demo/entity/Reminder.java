package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todo;
    @Column(name = "dead_line")
    private LocalDateTime deadLine;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public Reminder(String todo, LocalDateTime deadLine, Priority priority) {
        this.todo = todo;
        this.deadLine = deadLine;
        this.priority = priority;
    }
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "pk_person_reminder"))
    private Person person;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }
}
