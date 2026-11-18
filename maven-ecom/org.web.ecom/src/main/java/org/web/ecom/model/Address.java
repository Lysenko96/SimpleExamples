package org.web.ecom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    @JsonBackReference
    @ToString.Exclude
//    @OneToOne(mappedBy = "address", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private User user;

}



