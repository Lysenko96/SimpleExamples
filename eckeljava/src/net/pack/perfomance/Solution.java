package net.pack.perfomance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        for(int i = 0; i < 200; i++) {
            books.add(new Book(new ArrayList<>(Arrays.asList("1", "2"))));
            books.add(new Book(new ArrayList<>(Arrays.asList("4"))));
            books.add(new Book(new ArrayList<>(Arrays.asList("5", "6", "7"))));
            books.add(new Book(new ArrayList<>(Arrays.asList())));
        }
        long start = System.currentTimeMillis();
        System.out.println(start);
//        List<String> allPages = new ArrayList<>();
//        for(Book b : books){
//            allPages.addAll(b.getPages());
//        }
//        System.out.println(allPages.isEmpty());
        List<List<String>> all = books.stream().map(Book::getPages).filter(l -> !l.isEmpty()).collect(Collectors.toList());
        System.out.println(all.isEmpty());
        System.out.println(System.currentTimeMillis() - start);

    }
}

class Book {

    private List<String> pages;

    public Book(List<String> pages) {
        this.pages = pages;
    }

    public Book() {
    }

    public List<String> getPages() {
        return pages;
    }

    public void setPages(List<String> pages) {
        this.pages = pages;
    }
}
