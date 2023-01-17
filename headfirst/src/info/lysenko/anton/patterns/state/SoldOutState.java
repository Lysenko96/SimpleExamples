package info.lysenko.anton.patterns.state;

public class SoldOutState implements State{

    private MainState mainState;

    public SoldOutState(MainState mainState) {
        this.mainState = mainState;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("No gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs dispensed");
    }

    @Override
    public void refill() {
        mainState.setState(mainState.getNoQuarterState());
    }
}
