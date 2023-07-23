package org.example.jparelations.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Wife extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String job;
    //@OneToOne(mappedBy = "wife",  cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @OneToOne(mappedBy = "wife",  cascade = CascadeType.ALL)
    private Husband husband;

    public Wife(String firstName, String lastName, String phone, String email, long id, String job, Husband husband) {
        super(firstName, lastName, phone, email);
        this.id = id;
        this.job = job;
        this.husband = husband;
    }

    public Wife(String firstName, String lastName, String phone, String email, String job, Husband husband) {
        super(firstName, lastName, phone, email);
        this.job = job;
        this.husband = husband;
    }

    public Wife(String firstName, String lastName, String phone, String email, String job) {
        super(firstName, lastName, phone, email);
        this.job = job;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "id=" + id +
                ", job='" + job + '\'' +
                '}';
    }
}
