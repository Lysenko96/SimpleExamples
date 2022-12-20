package info.lysenko.anton.patterns.iterator1;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenuIterator<MenuItem> implements Iterator<MenuItem> {

    List<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return menuItems != null && position < menuItems.size();
    }

    @Override
    public MenuItem next() {
        MenuItem item = menuItems.get(position);
        position++;
        return item;
    }


    public Iterator<MenuItem> createIterator(){
        return new PancakeHouseMenuIterator<>(menuItems);
    }
}
