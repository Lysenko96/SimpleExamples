package com.example.demo.repository;

import com.example.demo.entity.Person;

import java.util.List;

public interface CustomPersonRepository {

    List<Person> findAllByRangeFetchNotesAndReminders(Long startId, Long endId);
}
