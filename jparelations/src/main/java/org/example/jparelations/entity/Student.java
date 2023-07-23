package org.example.jparelations.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String specialization;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    List<Subject> subjects;

    public Student(String firstName, String lastName, String phone, String email, String specialization) {
        super(firstName, lastName, phone, email);
        this.specialization = specialization;
    }

    public Student(String firstName, String lastName, String phone, String email, String specialization, List<Subject> subjects) {
        super(firstName, lastName, phone, email);
        this.specialization = specialization;
        this.subjects = subjects;
    }

    public Student(String firstName, String lastName, String phone, String email, String specialization, Teacher teacher) {
        super(firstName, lastName, phone, email);
        this.specialization = specialization;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
