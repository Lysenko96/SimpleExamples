package org.example.copyonwrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {

    public static void main(String[] args) {
        List<String> copyOnWrite = new CopyOnWriteArrayList<>(Arrays.asList("Java", "JavaSE", "JavaEE"));
        CopyOnWriteArraySet s;
        Main main = new Main();
        main.changeCopyOnWrite(true, copyOnWrite);
        main.changeCopyOnWrite(false, copyOnWrite);
    }

    void changeCopyOnWrite(boolean isChange, List<String> copyOnWrite) {
        Iterator<String> it = copyOnWrite.iterator();
        while (it.hasNext()) {
            String elem = it.next();
            if (isChange) {
                if (elem.equals("JavaEE")) {
                    copyOnWrite.add(null);
                    copyOnWrite.remove(elem);
                }
            }
            System.out.println(elem);
        }
        System.out.println();
    }
}
