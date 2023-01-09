package info.lysenko.anton.patterns.state;


public class HasQuarterState implements State {

    private MainState mainState;

    public HasQuarterState(MainState mainState) {
        this.mainState = mainState;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        mainState.setState(mainState.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned");
        mainState.setState(mainState.getSoldState());
        dispense();
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs dispensed");
    }
}
