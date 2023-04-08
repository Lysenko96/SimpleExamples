package info.lysenko.anton.patterns.state;

public class Monitor {

    MainState mainState;

    public Monitor(MainState mainState){
        this.mainState = mainState;
    }

    public void report(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "mainState=" + mainState +
                '}';
    }
}
