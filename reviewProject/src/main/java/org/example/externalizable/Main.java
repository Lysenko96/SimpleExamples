package org.example.externalizable;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {
        SubMyClass obj = new SubMyClass();
        obj.setId(1);
        obj.setName("test");
        obj.setSubId(2);
        obj.setSubName("subTest");

        try(FileOutputStream fos = new FileOutputStream("subTest.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try(FileInputStream fis = new FileInputStream("subTest.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            SubMyClass subMyClass = (SubMyClass) ois.readObject();
            System.out.println(subMyClass.getId());
            System.out.println(subMyClass.getName());
            System.out.println(subMyClass.getSubId());
            System.out.println(subMyClass.getSubName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
