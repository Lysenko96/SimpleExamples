package info.lysenko.anton.patterns.template;

public class Coffee extends CaffeineBeverage{

    public void brew(){
        System.out.println("dripping coffee through filter");
    }

    public void addComponents(){
        System.out.println("adding sugar");
    }
}
