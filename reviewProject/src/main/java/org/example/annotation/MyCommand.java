package org.example.annotation;

public class MyCommand {

    @Command(priority = 2, value = "myValue", description = "command annotation", aliases = {"command", "start"})
    private void command() {
        System.out.println("command");
    }

}
