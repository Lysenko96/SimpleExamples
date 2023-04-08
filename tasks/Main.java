package tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

    public static void main(String[] args) {
        System.out.println(new Main().check("The quick brown fox jumps over the lazy dog."));
        System.out.println(new Main().check("You shall not pass!"));
    }

    public boolean check(String sentence){
        Map<String, Long> res = Arrays.stream(sentence.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(String s : alphabet) {
            if (!res.containsKey(s)) return false;
        }
        return true;
    }
}
