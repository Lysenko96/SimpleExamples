package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {


    @Override
    @GetMapping("/persons/all")
    @Query("SELECT DISTINCT p FROM Person p JOIN FETCH p.notes")
    List<Person> findAll();

    @GetMapping("/persons/fetch/")
    @Query("SELECT DISTINCT p FROM Person p JOIN FETCH p.notes WHERE p.lastName = :lastName")
    List<Person> findAllByLastNameCustomFetchNotes(@Param("lastName") String lastName);

    @GetMapping("/persons/lastName")
    List<Person> findAllByLastName(@Param("lastName") String lastName);
}
