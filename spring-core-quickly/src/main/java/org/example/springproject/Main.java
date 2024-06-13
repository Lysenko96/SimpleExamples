package org.example.springproject;

import org.example.springproject.entity.Comment;
import org.example.springproject.service.CommentService;
import org.example.springproject.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
//        CommentService commentService = new CommentService(new CommentRepositoryDao(), new EmailCommentNotificationProxy());
//        commentService.publish(new Comment("author", "comment"));
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CommentService commentService2 = context.getBean(CommentService.class);
        commentService2.publish(new Comment("author2", "comment2"));
    }
}
