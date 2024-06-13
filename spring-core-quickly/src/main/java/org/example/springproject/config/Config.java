package org.example.springproject.config;

import org.example.springproject.proxy.CommentNotificationProxy;
import org.example.springproject.proxy.push.CommentPushNotificationProxy;
import org.example.springproject.repository.CommentRepository;
import org.example.springproject.repository.dao.CommentRepositoryDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.springproject")
public class Config {

    @Bean
    public CommentRepository commentRepository() {
        return new CommentRepositoryDao();
    }

//    @Bean
//    @Primary
//    public CommentNotificationProxy emailCommentNotificationProxy() {
//        return new EmailCommentNotificationProxy();
//    }

    @Bean("push")
    public CommentNotificationProxy commentPushNotificationProxy() {
        return new CommentPushNotificationProxy();
    }

//    @Bean
//    public CommentService commentService(CommentRepository commentRepository, @Qualifier("push") CommentNotificationProxy commentNotificationProxy) {
////    public CommentService commentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
//        return new CommentService(commentRepository, commentNotificationProxy);
//    }

}
