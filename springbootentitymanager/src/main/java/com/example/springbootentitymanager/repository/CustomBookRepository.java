package com.example.springbootentitymanager.repository;

import com.example.springbootentitymanager.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;


@Repository
public interface CustomBookRepository {
    List<Book> findAllByAuthors(Set<String> authors);
    Optional<Book> findBookById(Long id);
    List<Book> findAllByPredicate(Collection<Predicate<Book>> predicates);
}
