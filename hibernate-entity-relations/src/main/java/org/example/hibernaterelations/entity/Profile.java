package org.example.hibernaterelations.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "\"profile\"")
@Getter
@Setter
@ToString
public class Profile {

    @Id
    private Long id;
    private String photoUrl;
    private boolean active;
    @ToString.Exclude
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
