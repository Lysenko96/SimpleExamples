package org.example.springbootcache.service;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootcache.entity.Book;
import org.example.springbootcache.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Slf4j
//@RequiredArgsConstructor
public class BookServiceTest {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private BookService bookService;
    @SpyBean
    @Autowired
    private BookRepository bookRepository;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        book1 = new Book("title1", "author1");
        book2 = new Book("title2", "author2");
        book3 = new Book("title3", "author3");
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }

    @Test
    void testFindBookById() {
        Long id = 1L;
        Book book = bookService.findBookById(id);
        assertNotNull(book, "Book is not found");
        log.info("Book: " + book.getTitle());

        Book cacheBook = bookService.findBookById(id);
        assertNotNull(cacheBook, "Book is not found");
        log.info("Book: " + book.getTitle());

        verify(bookRepository, times(1)).findById(id);

        context.getBean("cacheManager");

    }

    @Test
    void testFindBookByIdNull() {
        Long id = 10L;
        Book book = bookService.findBookById(id);
        assertNull(book, "Book is found");

        Book cacheBook = bookService.findBookById(id);
        assertNull(cacheBook, "Book is found");

        verify(bookRepository, times(2)).findById(id);

        context.getBean("cacheManager");
    }

    @Test
    void testFindBookByTitleAndAuthor() {
        Book book = bookService.findBookByTitleAndAuthor("title1", "author1");
        assertNotNull(book, "Book is not found");
        log.info("Book: " + book.getTitle());

        Book cacheBook = bookService.findBookByTitleAndAuthor("title1", "author1");
        assertNotNull(cacheBook, "Book is not found");
        log.info("Book: " + book.getTitle());

        verify(bookRepository, times(1)).findBookByTitleAndAuthor("title1", "author1");

        context.getBean("cacheManager");
    }

    @Test
    void testSaveBookAndPutCache() {
        Book book = new Book("title4", "author4");
        bookService.saveBook(book);

        Long id = book.getId();

        Book foundedBook = bookService.findBookById(id);
        assertNotNull(foundedBook, "Book is not found");
        log.info("Book: " + book.getTitle());

        verify(bookRepository, never()).findById(id);

        context.getBean("cacheManager");

    }

    @Test
    void testDeleteBookAndCacheEvict() {
        Long id = 2L;
        Book foundedBook = bookService.findBookById(id);
        bookService.deleteBook(foundedBook);
        foundedBook = bookService.findBookById(id);
        assertNull(foundedBook, "Book is found");
    }

}
