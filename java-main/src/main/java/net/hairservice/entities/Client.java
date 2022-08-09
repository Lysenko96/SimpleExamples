package net.hairservice.entities;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private long id;
    private String name;
    private String surname;
    private int phone;
    private String email;
    private Role role;
    private String login;
    private String password;
    private Hairstyle hairstyle;

    public Client(String name, String surname, int phone, String email, Role role, String login, String password, Hairstyle hairstyle) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.login = login;
        this.password = password;
        this.hairstyle = hairstyle;
    }
}