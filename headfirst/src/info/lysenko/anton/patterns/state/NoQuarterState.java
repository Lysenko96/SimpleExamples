package info.lysenko.anton.patterns.state;

public class NoQuarterState implements State {

    private MainState mainState;

    public NoQuarterState(MainState mainState) {
        this.mainState = mainState;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        mainState.setState(mainState.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("Need to pay");
    }
}
