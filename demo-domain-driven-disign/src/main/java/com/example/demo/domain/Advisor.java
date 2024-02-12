package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Advisor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "advisor")
    private List<Application> applications = new ArrayList<>();

    enum Role {
        ASSOCIATE, PARTNER, LEAD
    }

    public void assignApplication(Application application) {
        application.assignTo(this);
        applications.add(application);
    }
}
