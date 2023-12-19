package com.example.springbootentitymanager.service;

import com.example.springbootentitymanager.entity.Book;
import com.example.springbootentitymanager.repository.BookRepository;
import com.example.springbootentitymanager.repository.CustomBookRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Service
@Transactional // need for insert custom @Query else error
public class BookService {
    private BookRepository bookRepository;
    private CustomBookRepository customBookRepository;

    public BookService(BookRepository bookRepository, CustomBookRepository customBookRepository) {
        this.bookRepository = bookRepository;
        this.customBookRepository = customBookRepository;
    }

    public Optional<Book> findById(EntityManager em, Book book){
        em.unwrap(Session.class).setFetchBatchSize(10);
        System.out.println("#################### AUTHOR NO BOOK: " +book.getAuthor());
       // Book bookRef = em.getReference(Book.class, book.getId()); // not call in db
        //System.out.println(bookRef);
//        book.getAuthor().setBook(bookRef);
       book = em.find(Book.class, book.getId());
        System.out.println("#################### AUTHOR HAS BOOK: " +book.getAuthor());
        return Optional.of(book);
    }

    @Cacheable(value = "book") // cache select 1 step if exclude @Cacheable select more then 1 step
    public Collection<Book> findAllByName(String name) {
        return bookRepository.findAllByName(name);
    }

    public Book save(Book book) {
        return  bookRepository.save(book);
    }

    public void delete(Book book){
        bookRepository.delete(book);
    }

    public void createBook(String name, String author){
        bookRepository.createBook(name, author);
    }

    public List<Book> findAllByAuthors(Set<String> authors){
        return customBookRepository.findAllByAuthors(authors);
    }

    public List<Book> findAllByPredicate(Collection<Predicate<Book>> predicates) {
        return customBookRepository.findAllByPredicate(predicates);
    }
}
