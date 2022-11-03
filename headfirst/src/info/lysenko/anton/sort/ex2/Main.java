package info.lysenko.anton.sort.ex2;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main<T> {

    public static void main(String[] args) {
        new info.lysenko.anton.sort.ex2.Main().go();
    }

    public void go(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(new Date()));
        Book b1 = new Book("b1", 3);
        Book b2 = new Book("b2", 1);
        Book b3 = new Book("b3", 2);
        Map<String, String> map = new HashMap<>();
        System.out.println(Float.parseFloat("0"));
        map.put("", "1");
        System.out.println(map.get("2"));
        System.out.println(map.keySet());
        List<GenreBook> genreBooks = new ArrayList<>();
        GenreBook g1 = new GenreBook("g1", 5);
        genreBooks.add(g1);
        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        TreeSet<Book> tree = new TreeSet<>(new BookCompare());
        //TreeSet<Book> tree = new TreeSet<>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        //System.out.println(tree);
        //takeBooks(genreBooks);
        //tree.add(g1);
        //bookList = takeBooks(genreBooks);
        System.out.println(bookList);
    }

    public <T extends GenreBook> List<T> takeBooks(List<T> l){
        //l.add(new Page("rst",1));
        l.add((T) new Book("trs", 22));
//        for(Book b : l)
//            System.out.println(b);
        return l;
    }

    public void takeBooks1(List<? extends Book> l){
        //l.add(new GenreBook("str",1));
        for(Book b : l)
            System.out.println(b.title);
    }
}

class Page extends Book {

    public Page(String title, int pageCounter) {
        super(title, pageCounter);
    }
}

class BookCompare implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        return book.pageCounter - t1.pageCounter;
    }
}

class GenreBook extends Book {

    public GenreBook(String title, int pageCounter) {
        super(title, pageCounter);
    }

    @Override
    public int compareTo(Book book) {
        return super.compareTo(book);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Book implements Comparable<Book>{

    String title;
    int pageCounter;

    public Book(String title, int pageCounter) {
        this.title = title;
        this.pageCounter = pageCounter;
    }

    @Override
    public int compareTo(Book book) {
        return title.compareTo(book.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCounter=" + pageCounter +
                '}';
    }
}
