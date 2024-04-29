package org.example.jmx;

public interface LibraryMBean {

    String getInfoLibrary();
    void showInfoLibrary();
    void setInfoLibrary(String infoLibrary);
    int addBookCounter(int bookCounter);
    int getBookCounter();
    void addBook(String title, String author);
    Book returnBook(int bookId);
}
