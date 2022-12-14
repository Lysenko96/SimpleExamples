package info.lysenko.anton.patterns.template;

public abstract class CaffeineBeverage {

    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addComponents();
    }

    public abstract void brew();

    public abstract void addComponents();

    public void boilWater(){
        System.out.println("boiling water");
    }
    public void pourInCup(){
        System.out.println("pouring into cup");
    }
}
