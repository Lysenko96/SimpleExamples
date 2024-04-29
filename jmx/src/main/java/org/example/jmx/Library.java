package org.example.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.ArrayList;
import java.util.List;

public class Library extends NotificationBroadcasterSupport implements LibraryMBean {

    private String libraryInfo = "Default info library";
    private int bookCounter;
    private List<Book> books = new ArrayList<>();
    private static long sequence;

    @Override
    public String getInfoLibrary() {
        return libraryInfo;
    }

    @Override
    public void showInfoLibrary() {
        System.out.println(libraryInfo);
        Notification notification = new AttributeChangeNotification(
                this, sequence++, System.currentTimeMillis(), libraryInfo, "sequence", "long", sequence-1, sequence
        );
        sendNotification(notification);
    }

    @Override
    public void setInfoLibrary(String infoLibrary) {
        this.libraryInfo = infoLibrary;
    }

    @Override
    public int addBookCounter(int bookCounter) {
        return this.bookCounter += bookCounter;
    }

    @Override
    public int getBookCounter() {
        return bookCounter;
    }

    @Override
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    @Override
    public Book returnBook(int bookId) {
        return books.get(bookId);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{AttributeChangeNotification.ATTRIBUTE_CHANGE};
        String name = AttributeChangeNotification.class.getName();
        String description = "AttributeChangeNotification";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
}
