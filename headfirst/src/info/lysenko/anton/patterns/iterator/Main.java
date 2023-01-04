package info.lysenko.anton.patterns.iterator;

import info.lysenko.anton.patterns.iterator1.DinerMenuIterator;

import java.util.*;

public class Main {

    MenuItem[] menuItems;
    List<MenuItem> menuItemList;

    public static void main(String[] args) {
//        Set<Long> set = Collections.singleton(5L);
//        System.out.println(set);
//        set.add(5L);
//        System.out.println(set);
        Main main = new Main();
        MenuItem menuItem = new MenuItem("item", "menuItem", false, 2.99);
        MenuItem menuItem1 = new MenuItem("item1", "menuItem1", true, 3.99);
        MenuItem menuItem2 = new MenuItem("item2", "menuItem2", false, 1.99);
        main.menuItems = new MenuItem[]{menuItem, menuItem1, menuItem2};
        main.menuItemList = new ArrayList<>();
        main.menuItemList.add(menuItem);
        main.menuItemList.add(menuItem1);
        main.menuItemList.add(menuItem2);


        DinerMenuIterator<MenuItem> dinerMenuIterator = new DinerMenuIterator<>(main.menuItems);
        CafeMenu cafeMenu = new CafeMenu();


        Iterator<MenuItem> iterator1 = dinerMenuIterator.createIterator();
        Iterator<MenuItem> iterator = main.menuItemList.iterator();
        Iterator<MenuItem> iterator2 = cafeMenu.createIterator();

        main.print(iterator);
        main.print(iterator1);
        main.print(iterator2);

    }

    private void print(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem);
        }
        System.out.println();
    }

}
