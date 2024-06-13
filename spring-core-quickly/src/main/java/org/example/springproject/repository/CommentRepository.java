package org.example.springproject.repository;

import org.example.springproject.entity.Comment;

public interface CommentRepository {

    Long save(Comment comment);
}
