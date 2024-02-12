package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, CustomPersonRepository {

    @Query("SELECT DISTINCT p FROM Person p JOIN FETCH p.notes WHERE p.id >= :startId AND p.id < :endId")
    List<Person> findAllByIdGreaterThanEqualAndIdLessThanAndNotes(@Param("startId") Long startId, @Param("endId") Long endId);
    @Query("SELECT DISTINCT p FROM Person p JOIN FETCH p.reminders WHERE p.id >= :startId AND p.id < :endId")
    List<Person> findAllByIdGreaterThanEqualAndIdLessThanNotesAndReminders(@Param("startId") Long startId, @Param("endId") Long endId);
}
