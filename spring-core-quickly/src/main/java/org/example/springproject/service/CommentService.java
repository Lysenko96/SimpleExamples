package org.example.springproject.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.aspectj.lang.annotation.AfterReturning;
import org.example.springproject.annotation.ToLog;
import org.example.springproject.annotation.ToLogAfterReturning;
import org.example.springproject.entity.Comment;
import org.example.springproject.proxy.CommentNotificationProxy;
import org.example.springproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@Getter
@Setter
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Lazy
@Log
public class CommentService {

//    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Autowired
    private ApplicationContext context;

//        @Autowired
    private CommentRepository commentRepository;
    //    private final CommentRepository commentRepository;
//    @Autowired
    private final CommentNotificationProxy commentNotificationProxy;
//    private final CommentNotificationProxy commentNotificationProxy;


    public CommentService(ApplicationContext context, CommentRepository commentRepository, @Qualifier("push") CommentNotificationProxy commentNotificationProxy) {
        log.info("CommentService instantiated");
//        log.("CommentService constructor");
//        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }


    public String publish(Comment comment) {
//        log.info("Publish comment: " + comment);
        commentRepository = context.getBean(CommentRepository.class);
        Long id = commentRepository.save(comment);
        comment.setId(id);
        commentNotificationProxy.send(comment);
        return "SUCCESS";
    }

    @ToLog
    public String delete(Comment comment) {
        log.info("Deleting comment: " + comment);
        return "DELETE";
    }

    @ToLogAfterReturning
    public String edit(Comment comment) {
        log.info("Editing comment: " + comment);
        return "EDIT";
    }
}
