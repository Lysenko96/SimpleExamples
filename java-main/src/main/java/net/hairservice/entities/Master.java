package net.hairservice.entities;

import lombok.*;

import java.io.File;
import java.sql.Blob;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Master {

    private long id;
    private Blob photo;
    private String name;
    private String surname;
    private int phone;
    private String email;
    private Role role;
    private String login;
    private String password;
    private List<Duration> durations;

    public Master(Blob photo, String name, String surname, int phone, String email, Role role, String login, String password, List<Duration> durations) {
        this.photo = photo;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.login = login;
        this.password = password;
        this.durations = durations;
    }
}