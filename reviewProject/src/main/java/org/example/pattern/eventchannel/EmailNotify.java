package org.example.pattern.eventchannel;

import java.util.List;

public class EmailNotify implements Publisher{

    List<User> users;
    String news;

    public EmailNotify(List<User> users) {
        this.users = users;
    }

    public void setNews(String news) {
        this.news = news;
        notify(news);
    }

    @Override
    public void register(User user) {
        users.add(user);
    }

    @Override
    public void remove(User user) {
        users.remove(user);
    }

    @Override
    public void notify(String message) {
        users.stream().forEach(u -> u.update(message));
    }
}
