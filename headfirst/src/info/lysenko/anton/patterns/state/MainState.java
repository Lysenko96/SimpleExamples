package info.lysenko.anton.patterns.state;

import java.util.Random;

public class MainState {

    private State state;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State soldOutState;
    private State winnerState;
    private int count;

    public MainState(int count) {
        this.count = count;
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);
        if(count > 0){
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public static void main(String[] args) {
        MainState mainState = new MainState(3);
       // int value = new Random().nextInt(10);

//        if(value == 2 && mainState.getCount() > 2){
//            mainState.setState(new WinnerState(mainState));
//        }

        System.out.println(mainState);

        mainState.insertQuarter();
        mainState.turnCrank();

        System.out.println(mainState);

        mainState.insertQuarter();
        mainState.ejectQuarter();
        mainState.turnCrank();

        System.out.println(mainState);

        mainState.insertQuarter();
        mainState.turnCrank();
        mainState.ejectQuarter();

        System.out.println(mainState);

        mainState.insertQuarter();
        mainState.insertQuarter();
        mainState.turnCrank();

        System.out.println(mainState);


    }

    void insertQuarter(){
        state.insertQuarter();
    }

    void ejectQuarter(){
        state.ejectQuarter();
    }

    void turnCrank(){
        state.turnCrank();
        state.dispense();
    }


    public State getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public void setWinnerState(State winnerState) {
        this.winnerState = winnerState;
    }

    @Override
    public String toString() {
        return "MainState{" +
                "count=" + count +
                '}';
    }
}
