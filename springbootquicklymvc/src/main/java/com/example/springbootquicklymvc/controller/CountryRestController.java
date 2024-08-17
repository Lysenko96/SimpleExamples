package com.example.springbootquicklymvc.controller;

import com.example.springbootquicklymvc.entity.Country;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/rest/country")
public class CountryRestController {

    private static final List<Country> countries = new ArrayList<>();
    private static final Map<String, HttpHeaders> headers = new HashMap<>();

    static {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("continent", "Europe");
        httpHeaders.add("capital", "Paris");
        httpHeaders.add("favorite_food", "cheese and wine");
        headers.put("france", httpHeaders);

        httpHeaders = new HttpHeaders();

        httpHeaders.add("continent", "Europe");
        httpHeaders.add("capital", "Madrid");
        httpHeaders.add("favorite_food", "paella");
        headers.put("spain", httpHeaders);
    }

    static {
        Country c1 = Country.of("France", 67);
        Country c2 = Country.of("Spain", 47);
        countries.add(c1);
        countries.add(c2);
    }

    @GetMapping("/{country}")
    public ResponseEntity<Country> france(@PathVariable String country) {
//        return countries.stream().filter(c -> c.getName().equalsIgnoreCase(country))
//                .findFirst()
//                .orElse(null);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .headers(headers.get(country.toLowerCase(Locale.ROOT)))
                .body(countries.stream().filter(c -> c.getName().equalsIgnoreCase(country))
                        .findFirst().orElse(null));
    }

    @GetMapping("/all")
    public List<Country> all() {
        return countries;
    }
}
