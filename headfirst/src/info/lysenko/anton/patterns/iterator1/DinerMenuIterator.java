package info.lysenko.anton.patterns.iterator1;

import java.util.Iterator;

public class DinerMenuIterator<MenuItem> implements Iterator<MenuItem> {

    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }

    public Iterator<MenuItem> createIterator(){
        return new DinerMenuIterator<>(items);
    }
}
