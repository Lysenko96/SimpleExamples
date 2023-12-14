package com.example.springbootentitymanager;

import com.example.springbootentitymanager.config.EntityManagerConfig;
import com.example.springbootentitymanager.entity.Book;
import com.example.springbootentitymanager.repository.CustomBookRepository;
import com.example.springbootentitymanager.service.BookService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.EntityType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@SpringBootApplication
@EnableCaching
@Slf4j
public class SpringBootEntityManagerApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(SpringBootEntityManagerApplication.class, args);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        EntityManagerConfig config = context.getBean(EntityManagerConfig.class);
        System.out.println(config.dataSource == dataSource); // if use @Component instead @Configuration result false else true
    }

//    @Bean
//    public CommandLineRunner run(BookService bookService){
//        return args -> {
//            addBook(bookService);
//            bookService.findAllByName("Clean Code");
//            System.out.println(bookService.findAllByName("Clean Code"));
//            bookService.createBook("Think in Java", "Eckel Bruce");
//            findAllByAuthors(bookService);
//        };
//    }

    private void findAllByAuthors(BookService bookService) {
        List<Book> books = bookService.findAllByAuthors(Set.of("Eckel Bruce"));
        List<Predicate<Book>> predicates = Collections.singletonList(Predicate.not(book -> book.getAuthor().equals("Eckel Bruce")));
        log.info("findAllByPredicate books :" + bookService.findAllByPredicate(predicates));
        log.info("findAllByAuthors books: " + books);
    }

    private void addBook(BookService bookService) {
        System.out.println(bookService.save(new Book("Clean Code", "Bob Martin")));
    }

}
