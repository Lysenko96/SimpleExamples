package org.example.petproject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    @ElementCollection
    List<String> links;
    @ElementCollection
    List<String> skills;
    @ManyToOne
    @JoinColumn(name = "resume_id")
    Resume resume;
}
