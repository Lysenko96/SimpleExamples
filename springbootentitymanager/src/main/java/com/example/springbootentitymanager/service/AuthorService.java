package com.example.springbootentitymanager.service;

import com.example.springbootentitymanager.entity.Author;
import com.example.springbootentitymanager.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public Optional<Author> findById(Long id){
        return authorRepository.findById(id);
    }
}
