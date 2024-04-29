package org.example.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        try {
            ObjectName objectName = new ObjectName("org.example.jmx:type=Library");
            Library library = new Library();
            server.registerMBean(library, objectName);
            LibraryMBean libraryMBean = JMX.newMBeanProxy(server, objectName, LibraryMBean.class);

            libraryMBean.addBook("title", "author");
            System.out.println(libraryMBean.getInfoLibrary());
            int bookId = libraryMBean.getBookCounter();
            System.out.println(bookId);
            System.out.println(libraryMBean.addBookCounter(1));
            System.out.println(libraryMBean.returnBook(bookId));

            System.out.println("Server starting...");
            while (true) {}
        } catch (MalformedObjectNameException | NotCompliantMBeanException | InstanceAlreadyExistsException |
                 MBeanRegistrationException e) {
            throw new RuntimeException(e);
        }
    }
}
