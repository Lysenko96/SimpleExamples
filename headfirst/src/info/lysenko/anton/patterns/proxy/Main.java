package info.lysenko.anton.patterns.proxy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<String> all = new ArrayList<>(Arrays.asList("5232","yv","22","c","yawgs","928","4003","2"));
        for(String w : all) {
            try {
                numbers.add(Integer.parseInt(w));
            } catch (Exception e) {
                words.add(w);
            }
        }
        List<Integer> sizesW = new ArrayList<>();
        List<Integer> sizesN = new ArrayList<>();
        for(String w : words){
            sizesW.add(w.length());
        }
        for(Integer n : numbers){
            sizesN.add(String.valueOf(n).length());
        }
        sizesW.sort(Collections.reverseOrder());
        sizesN.sort(Collections.reverseOrder());
        System.out.println(sizesW.get(0));
        System.out.println(sizesN.get(0));
        if(sizesW.get(0) > sizesN.get(0)){
           Collections.sort(words);
            System.out.println(words.get(0).length());
        } else {
            Collections.sort(numbers);
            System.out.println(numbers.get(0));
        }

    }
}
