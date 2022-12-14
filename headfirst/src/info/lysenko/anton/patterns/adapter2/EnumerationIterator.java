package info.lysenko.anton.patterns.adapter2;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator<T> implements Iterator<T> {

    Enumeration<T> enumeration;

    public EnumerationIterator(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }
}
