package org.example.petproject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Level level;
    @ManyToOne
    @JoinColumn(name = "resume_id")
    Resume resume;

    public Language(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public enum Level {
        ELEMENTARY, PRE_INTERMEDIATE, INTERMEDIATE, UPPER_INTERMEDIATE, ADVANCED, PROFICIENCY
    }
}
