package com.example.springbootentitymanager.repository.em;

import com.example.springbootentitymanager.entity.Book;
import com.example.springbootentitymanager.repository.CustomBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Getter
@Repository
public class EntityManagerCustomBookRepository implements CustomBookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Book> findBookById(Long id) {
        Book book = entityManager.find(Book.class, id);
        Optional<Book> result;
        if(book != null) result = Optional.of(book);
        else result = Optional.empty();
        return result;
    }

    @Override
    public List<Book> findAllByAuthors(Set<String> authors) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> user = query.from(Book.class);

        Path<String> authorPath = user.get("author");

        List<Predicate> predicates = new ArrayList<>();
        for (String author : authors) {
            predicates.add(cb.like(authorPath, author));
        }

        query.select(user).where(cb.or(predicates.toArray(Predicate[]::new)));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Book> findAllByPredicate(Collection<java.util.function.Predicate<Book>> predicates) {
        List<Book> allUsers = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        Stream<Book> allUsersStream = allUsers.stream();
        for (java.util.function.Predicate<Book> predicate : predicates) {
            allUsersStream = allUsersStream.filter(predicate);
        }

        return allUsersStream.collect(Collectors.toList());
    }
}
