package org.example.springproject.proxy.push;

import org.example.springproject.entity.Comment;
import org.example.springproject.proxy.CommentNotificationProxy;

public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void send(Comment comment) {
        System.out.println("Sending comment: " + comment + " to push notification");

    }
}
