package info.lysenko.anton.patterns.state;

public class SoldState implements State{

    private MainState mainState;


    public SoldState(MainState mainState) {
        this.mainState = mainState;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Doesn't get you another gumball");
    }

    @Override
    public void dispense() {
            System.out.println("Take gumball");
            mainState.setCount(mainState.getCount() - 1);
            if (mainState.getCount() == 0) {
                System.out.println("No gumballs");
                mainState.setState(mainState.getSoldOutState());
            } else {
                mainState.setState(mainState.getNoQuarterState());
            }
    }

    @Override
    public void refill() {

    }
}
