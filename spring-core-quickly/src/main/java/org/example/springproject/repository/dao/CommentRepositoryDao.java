package org.example.springproject.repository.dao;

import org.example.springproject.entity.Comment;
import org.example.springproject.repository.CommentRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentRepositoryDao implements CommentRepository {

    private static long id;

    @Override
    public Long save(Comment comment) {
        System.out.println("Saving comment: " + comment);
        return ++id;
    }
}
