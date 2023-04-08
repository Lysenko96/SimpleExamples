package info.lysenko.anton.patterns.state;

import java.util.Random;

public class WinnerState implements State {

    private MainState mainState;
    Random random = new Random(System.currentTimeMillis());

    public WinnerState(MainState mainState) {
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
        int winner  = random.nextInt(10);
        if(winner == 0 && mainState.getCount() > 1){
            mainState.setState(mainState.getWinnerState());
        } else {
            mainState.setState(mainState.getSoldState());
            //mainState.refill(2);
        }
    }

    @Override
    public void dispense() {
//        if (mainState.getCount() == 0) {
//            System.out.println("No gumballs");
//            mainState.setState(mainState.getSoldOutState());
//        } else if (mainState.getCount() >= 2){
//            mainState.setCount(mainState.getCount() - 2);
//            System.out.println("Take two gumballs");
//            mainState.setState(mainState.getNoQuarterState());
//        } else {
//            mainState.setCount(mainState.getCount() - 1);
//            System.out.println("Take last gumball");
//            mainState.setState(mainState.getNoQuarterState());
//        }
        System.out.println("No gumballs dispensed");
    }

    @Override
    public void refill() {

    }

}
