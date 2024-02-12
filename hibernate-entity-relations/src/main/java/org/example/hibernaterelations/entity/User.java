package org.example.hibernaterelations.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
//@Table(name = "my_user")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    public User(String username) {
        this.username = username;
    }

    public void setAddress(Address address) {
        address.setUser(this);
        this.address = address;
    }

    public void setProfile(Profile profile) {
        profile.setUser(this);
        this.profile = profile;
    }
}
