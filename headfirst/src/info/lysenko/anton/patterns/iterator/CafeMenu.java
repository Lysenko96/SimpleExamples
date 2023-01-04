package info.lysenko.anton.patterns.iterator;

import java.util.HashMap;
import java.util.Iterator;

public class CafeMenu implements Menu<MenuItem>{

    HashMap<String, MenuItem> menuItems = new HashMap<>();

    public CafeMenu(){
        addItem("item", "menuItem", false, 2.99);
        addItem("item1", "menuItem1", true, 3.99);
        addItem("item2", "menuItem2", false, 1.99);

    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    public Iterator<MenuItem> createIterator(){
        return menuItems.values().iterator();
    }
}
