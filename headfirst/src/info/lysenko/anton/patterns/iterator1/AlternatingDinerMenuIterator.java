package info.lysenko.anton.patterns.iterator1;


import info.lysenko.anton.patterns.iterator.Menu;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator<MenuItem> implements Iterator<MenuItem>, Menu<MenuItem> {

    MenuItem[] items;
    int position;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        position = Calendar.DAY_OF_WEEK % 2;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position += 2;
        return menuItem;
    }

    @Override
    public void remove() {
       throw new UnsupportedOperationException("Alternating Diner Menu Iterator does not support remove()");
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new AlternatingDinerMenuIterator<>(items);
    }
}
