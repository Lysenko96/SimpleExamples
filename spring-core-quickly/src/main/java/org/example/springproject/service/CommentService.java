package org.example.springproject.service;

import org.example.springproject.entity.Comment;
import org.example.springproject.proxy.CommentNotificationProxy;
import org.example.springproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class CommentService {

//    @Autowired
    private  CommentRepository commentRepository;
//    private final CommentRepository commentRepository;
//    @Autowired
    private  CommentNotificationProxy commentNotificationProxy;
//    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, @Qualifier("push") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publish(Comment comment) {
        Long id = commentRepository.save(comment);
        comment.setId(id);
        commentNotificationProxy.send(comment);
    }
}
