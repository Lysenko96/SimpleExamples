package org.example.springcorequickly.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//@NoArgsConstructor
@AllArgsConstructor
@Data
//@Component
public class Parrot {

    private String name;

    public Parrot() {
        System.out.println("Parrot constructor");
    }
}
