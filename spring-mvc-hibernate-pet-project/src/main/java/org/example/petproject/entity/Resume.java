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
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String summary;
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    List<Education> educations;
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    List<Experience> experiences;
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    List<Language> languages;
    @ElementCollection
    List<String> skills;
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    List<Project> projects;
    @OneToOne(mappedBy = "resume", cascade = CascadeType.ALL)
    User user;
}
