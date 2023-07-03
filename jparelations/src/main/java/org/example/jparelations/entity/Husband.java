package org.example.jparelations.entity;

import lombok.*;

import javax.persistence.*;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Husband extends Person  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String job;
    @OneToOne( cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) // deleted husband but not deleted wife
    //@OneToOne(cascade = CascadeType.ALL) // deleted all
    @JoinColumn(name = "wife_id")
    private Wife wife;

    public Husband(String firstName, String lastName, String phone, String email, long id, String job, Wife wife) {
        super(firstName, lastName, phone, email);
        this.id = id;
        this.job = job;
        this.wife = wife;
    }

    public Husband(String firstName, String lastName, String phone, String email, String job, Wife wife) {
        super(firstName, lastName, phone, email);
        this.job = job;
        this.wife = wife;
    }
}
