package org.example.springproject.proxy;

import org.example.springproject.entity.Comment;

public interface CommentNotificationProxy {

    void send(Comment comment);
}
