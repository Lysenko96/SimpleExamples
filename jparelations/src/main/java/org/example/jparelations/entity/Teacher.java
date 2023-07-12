package org.example.jparelations.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Teacher extends Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String subject;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    List<Student> students;

    public Teacher(String firstName, String lastName, String phone, String email, long id, String subject, List<Student> students) {
        super(firstName, lastName, phone, email);
        this.id = id;
        this.subject = subject;
        this.students = students;
    }

    public Teacher(String firstName, String lastName, String phone, String email, String subject, List<Student> students) {
        super(firstName, lastName, phone, email);
        this.subject = subject;
        this.students = students;
    }
}
