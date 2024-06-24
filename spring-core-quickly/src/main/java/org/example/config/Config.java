package org.example.config;

import org.example.aspect.LoggingAspect;
import org.example.aspect.SecurityAspect;
import org.example.springproject.proxy.CommentNotificationProxy;
import org.example.springproject.proxy.push.CommentPushNotificationProxy;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example.springproject")
@EnableAspectJAutoProxy
public class Config {

//    @Bean
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public CommentRepository commentRepository() {
//        return new CommentRepositoryDao();
//    }

//    @Bean
//    @Primary
//    public CommentNotificationProxy emailCommentNotificationProxy() {
//        return new EmailCommentNotificationProxy();
//    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public SecurityAspect securityAspect(){
        return new SecurityAspect();
    }

    @Bean("push")
    public CommentNotificationProxy commentPushNotificationProxy() {
        return new CommentPushNotificationProxy();
    }

//    @Bean
//    @Lazy
//    @Scope("prototype")
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public CommentService commentService(CommentRepository commentRepository, @Qualifier("push") CommentNotificationProxy commentNotificationProxy) {
////    public CommentService commentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
//        return new CommentService(commentRepository, commentNotificationProxy);
//    }

}
