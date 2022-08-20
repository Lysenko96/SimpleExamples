package net.mega.webshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private int phone;
    private String email;

    public Seller(String firstName, String lastName, String username, String password, String address, int phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
