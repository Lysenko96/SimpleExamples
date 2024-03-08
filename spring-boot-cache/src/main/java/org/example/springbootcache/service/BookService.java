package org.example.springbootcache.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootcache.entity.Book;
import org.example.springbootcache.repository.BookRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Cacheable(value = "book", unless = "#result == null")
    public Book findBookById(Long id) {
        log.info("findBookById");
        return bookRepository.findById(id).orElse(null);
    }

    @Cacheable(value = "book", key = "#title", unless = "#result == null")
    public Book findBookByTitleAndAuthor(String title, String author) {
        log.info("findBookByTitleAndAuthor");
        return bookRepository.findBookByTitleAndAuthor(title, author).orElse(null);
    }

    @CachePut(value = "book", key = "#book.id")
    public Book saveBook(Book book) {
        log.info("saveBook");
        return bookRepository.save(book);
    }

    @CacheEvict(value = "book", key="#book.id")
    public void deleteBook(Book book) {
        log.info("deleteBook");
        bookRepository.delete(book);
    }
}
