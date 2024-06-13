package org.example.springcorequickly.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Person {

    private String name;
//    private final Parrot parrot = new Parrot();
//    @Autowired
//    @Qualifier("parrot2")
    private Parrot parrot;

   // @Autowired // (less priority) if not bean in @Configuration class
   // @Autowired worked if class have one constructor
    @Autowired
    public Person(@Qualifier("parrot2") Parrot parrot) {
        this.parrot = parrot;
    }

//    @Autowired
//    public void setParrot(Parrot parrot) {
//        parrot.setName("Koko");
//        this.parrot = parrot;
//    }
}
