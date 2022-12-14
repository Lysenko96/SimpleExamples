package info.lysenko.anton.patterns.template;

public class Main {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        tea.prepareRecipe();
        System.out.println();
        coffee.prepareRecipe();
    }
}
