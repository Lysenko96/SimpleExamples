package info.lysenko.anton.patterns.iterator;

import java.util.Iterator;

public interface Menu<MenuItem> {

     Iterator<MenuItem> createIterator();
}
