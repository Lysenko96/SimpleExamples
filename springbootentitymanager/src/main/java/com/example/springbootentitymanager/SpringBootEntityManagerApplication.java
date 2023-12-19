package com.example.springbootentitymanager;

import com.example.springbootentitymanager.config.EntityManagerConfig;
import com.example.springbootentitymanager.entity.Author;
import com.example.springbootentitymanager.entity.Book;
import com.example.springbootentitymanager.repository.CustomBookRepository;
import com.example.springbootentitymanager.repository.em.EntityManagerCustomBookRepository;
import com.example.springbootentitymanager.service.AuthorService;
import com.example.springbootentitymanager.service.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.EntityType;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.*;
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
        BookService bookService = context.getBean("bookService", BookService.class);
        AuthorService authorService = context.getBean("authorService", AuthorService.class);
        Book myBook = new Book("Think in Java");
        Book myBook3 = new Book("Think in Java");
        bookService.save(myBook);
        bookService.delete(myBook);
        // bookService.save(myBook3); // error (unique book name) because insert has more priority by delete
        Author author = new Author("Bruce Eckel", myBook);
        author.setBirthDateYear("1977");
        Author author2 = new Author("Cay S. Horstmann");
        author2.setBirthDateYear("1966");
        authorService.save(author);
        myBook.setAuthor(author);
        bookService.save(myBook);
        //myBook.setAuthor(null); // remove author from my_author if orphanRemoval = true
        //bookService.save(myBook);
        //authorService.save(author2); // error if use cascade = CascadeType.PERSIST
        Book myBook2 = new Book("Java Core", author2);
        bookService.save(myBook2);
        Optional<Author> authorResult = authorService.findById(author2.getId());
        authorResult.ifPresent(author1 -> log.info(String.valueOf(author1)));
        EntityManagerCustomBookRepository entityManagerCustomBookRepository = context.getBean(EntityManagerCustomBookRepository.class);

        EntityManager em = entityManagerCustomBookRepository.getEntityManager();

        Optional<Book> bookResult = bookService.findById(em, myBook2);
        bookResult.ifPresent(book -> log.info(String.valueOf(book.getAuthor())));
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
        //System.out.println(bookService.save(new Book("Clean Code", "Bob Martin")));
    }

}
