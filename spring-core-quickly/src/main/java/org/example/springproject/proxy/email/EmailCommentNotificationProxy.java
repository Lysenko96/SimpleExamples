package org.example.springproject.proxy.email;

import org.example.springproject.entity.Comment;
import org.example.springproject.proxy.CommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("email")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void send(Comment comment) {
        System.out.println("Sending comment: " + comment + " to email");
    }
}
