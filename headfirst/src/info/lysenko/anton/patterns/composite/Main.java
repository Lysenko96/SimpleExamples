package info.lysenko.anton.patterns.composite;


public class Main {

    public static void main(String[] args) {
        MenuComponent one = new Menu("one", "one");
        MenuComponent two = new Menu("two", "two");
        MenuComponent three = new Menu("three", "three");

        MenuComponent allMenus = new Menu("all", "all");

        allMenus.add(one);
        allMenus.add(two);
        allMenus.add(three);


        MenuItem menuItem = new MenuItem("item", "menuItem", false, 2.99);
        MenuItem menuItem1 = new MenuItem("item1", "menuItem1", true, 3.99);
        MenuItem menuItem2 = new MenuItem("item2", "menuItem2", false, 1.99);

        one.add(menuItem);
        one.add(menuItem1);
        one.add(menuItem2);

         menuItem = new MenuItem("itemTwo", "menuItemTwo", false, 2.99);
         menuItem1 = new MenuItem("itemTwo1", "menuItemTwo1", true, 3.99);
         menuItem2 = new MenuItem("itemTwo2", "menuItemTwo2", false, 1.99);

        two.add(menuItem);
        two.add(menuItem1);
        two.add(menuItem2);

        menuItem = new MenuItem("itemThree", "menuItemThree", false, 2.99);

        three.add(menuItem);

        two.add(three);

        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();

    }
}
