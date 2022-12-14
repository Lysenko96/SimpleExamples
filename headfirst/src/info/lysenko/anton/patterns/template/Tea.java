package info.lysenko.anton.patterns.template;

public class Tea extends CaffeineBeverage{

    public void brew(){
        System.out.println("stepping the tea");
    }

    public void addComponents(){
        System.out.println("adding lemon");
    }
}
