package info.lysenko.anton.patterns.iterator1;


import info.lysenko.anton.patterns.iterator.Menu;

import java.util.Iterator;

public class DinerMenuIterator<MenuItem> implements Iterator<MenuItem>, Menu<MenuItem> {

    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }

    @Override
    public void remove() {
        if(position <= 0){
            throw new IllegalStateException("You can’t remove an item until you’ve done at least one next()");
        }
        if(items[position-1] != null) {
            for(int i = position - 1; i < (items.length-1); i++){
                items[i] = items[i + 1];
            }
            items[items.length-1] = null;
        }
    }

    @Override
     public Iterator<MenuItem> createIterator(){
        return new DinerMenuIterator<>(items);
    }
}
