package org.example.pattern.eventchannel;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Deprecated
public class Main {

    @SuppressWarnings("all")
    private final List versions = new ArrayList();

    public static void main(String[] args) {
        EmailNotify emailNotify = new EmailNotify(new ArrayList<>());
        new User("user1", emailNotify);
        new User("user2", emailNotify);
        emailNotify.setNews("Hello World!");
    }

    @SuppressWarnings("unchecked")
    public void show() throws Exception {
        versions.add("space");
        System.out.println(((String) versions.getFirst()).toUpperCase(Locale.ROOT));
    }
}

@Documented
@interface Log {

}