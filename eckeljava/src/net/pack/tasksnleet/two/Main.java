package net.pack.tasksnleet.two;

//import net.pack.tasks.one.Main;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        new net.pack.tasksnleet.one.Main().main(args);
        new net.pack.tasksnleet.two.debug.Solution().debug("hello");
        new net.pack.tasksnleet.two.debugoff.Solution().debug();
    }
}
