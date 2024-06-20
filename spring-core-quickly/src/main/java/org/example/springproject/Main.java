package org.example.springproject;

import lombok.extern.java.Log;
import org.example.springproject.entity.Comment;
import org.example.springproject.service.CommentService;
import org.example.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
public class Main {

    public static void main(String[] args) {
//        CommentService commentService = new CommentService(new CommentRepositoryDao(), new EmailCommentNotificationProxy());
//        commentService.publish(new Comment("author", "comment"));
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        System.out.println("Before Comment Service");
//        CommentService commentService2 = context.getBean("commentService", CommentService.class);
//        CommentRepository commentRepository2 = context.getBean(CommentRepository.class);
//        CommentRepository commentRepository3 = context.getBean(CommentRepository.class);
//        commentService2.setCommentRepository(commentRepository2);
//        System.out.println("After Comment Service");
        CommentService commentService3 = context.getBean("commentService", CommentService.class);
//        System.out.println(commentService3);
//        commentService3.setCommentRepository(commentRepository3);
//        UserService userService = context.getBean("userService", UserService.class);
//        System.out.println(commentService2);
//        System.out.println(commentService3);
//        System.out.println(commentService3 == commentService2); // true
//        System.out.println(userService.getCommentRepository() == commentService2.getCommentRepository());
//        commentService2.publish(new Comment("author2", "comment2"));
        String value = commentService3.publish(new Comment("author3", "comment3"));
        log.info(value);
        //        System.out.println(commentService3.getCommentRepository() == commentService2.getCommentRepository());
    }
}
