package org.example.springproject.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.springproject.repository.CommentRepository;
import org.example.springproject.repository.dao.CommentRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@Getter
public class UserService {

    @Autowired
    private CommentRepository commentRepository;
}
