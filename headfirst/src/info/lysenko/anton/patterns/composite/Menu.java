package info.lysenko.anton.patterns.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent{

    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void print(){
        System.out.println(this);

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuComponents=" + menuComponents +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
