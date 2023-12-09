package com.example.springbootentitymanager.repository;

import com.example.springbootentitymanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("FROM Book WHERE name = :name")
    Collection<Book> findAllByName(@Param("name") String name);

    @Modifying // need for insert else error
    @Query(value = "INSERT INTO my_book (this_name, author) VALUES (:name, :author)", nativeQuery = true)
    void createBook(@Param("name") String name, @Param("author") String author);
}
