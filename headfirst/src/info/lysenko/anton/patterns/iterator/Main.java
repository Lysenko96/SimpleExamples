package info.lysenko.anton.patterns.iterator;

import info.lysenko.anton.patterns.iterator1.DinerMenuIterator;
import info.lysenko.anton.patterns.iterator1.PancakeHouseMenuIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        Main main = new Main();
        MenuItem menuItem = new MenuItem("item", "menuItem", false, 2.99);
        MenuItem menuItem1 = new MenuItem("item1", "menuItem1", true, 3.99);
        MenuItem menuItem2 = new MenuItem("item2", "menuItem2", false, 1.99);
        MenuItem[] menuItems = new MenuItem[]{menuItem, menuItem1, menuItem2};
        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(menuItem);
        menuItemList.add(menuItem1);
        menuItemList.add(menuItem2);
//        for(int i = 0; i < menuItems.length; i++){
//            System.out.println(menuItemList.get(i));
//            System.out.println(menuItems[i]);
//        }

      //  Iterator<MenuItem> iterator = main.menuItemList.iterator();

//        while (iterator.hasNext()){
//            MenuItem item = iterator.next();
//            System.out.println(item);
//        }

        //Iterator<MenuItem> listIterator = main.listIterator();

        DinerMenuIterator<MenuItem> dinerMenuIterator = new DinerMenuIterator<>(menuItems);
        PancakeHouseMenuIterator<MenuItem> pancakeHouseMenuIterator = new PancakeHouseMenuIterator<>(menuItemList);

        Iterator<MenuItem> iterator1 = dinerMenuIterator.createIterator();

        Iterator<MenuItem> iterator2 = pancakeHouseMenuIterator.createIterator();

        main.print(iterator1);

        main.print(iterator2);


    }

    private void print(Iterator<MenuItem> iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem);
        }
    }

}

class MenuItem {

    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}';
    }
}
