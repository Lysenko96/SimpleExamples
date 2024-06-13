package org.example.springproject.repository.dao;

import org.example.springproject.entity.Comment;
import org.example.springproject.repository.CommentRepository;

//@Repository
public class CommentRepositoryDao implements CommentRepository {

    private static long id;

    @Override
    public Long save(Comment comment) {
        System.out.println("Saving comment: " + comment);
        return ++id;
    }
}
