package com.example.javabasic.streamapi.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Solution {

    public static void main(String[] args) {
        File dictionary = new File("/home/user/Documents/Spd/javabasic/src/main/java/com/example/javabasic/streamapi/test/words");
        int minGroupSize = 2;
        Map<String, Set<String>> groups = new HashMap<>();

//       try(Scanner in = new Scanner(dictionary)){
//            while (in.hasNext()) {
//                String word = in.next();
//                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
//            }
//            for(Map.Entry<String, Set<String>> pair : groups.entrySet()){
//                if(pair.getValue().size() >= minGroupSize){
//                    System.out.println(pair.getValue().size() + " " + pair.getKey() + ": " + pair.getValue());
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try (Stream<String> words = Files.lines(dictionary.toPath())) {
            words.collect(groupingBy(Solution::alphabetize))
                    .entrySet().stream()
                    .filter(pair -> pair.getValue().size() >= minGroupSize)
                    .forEach(pair -> System.out.println(pair.getValue().size() + " " + pair.getKey() + ": " + pair.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String alphabetize(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
