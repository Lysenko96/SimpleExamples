package info.lysenko.anton;

public class MainState {

    final static  int SOLD_OUT = 0;
    final static  int NO_QUARTER = 1;
    final static  int HAS_QUARTER = 2;
    final static  int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public MainState(int count) {
        this.count = count;
        if(count > 0){
            state = NO_QUARTER;
        }
    }

    public static void main(String[] args) {
        MainState mainState = new MainState(3);
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

    public void insertQuarter(){
        if(state == HAS_QUARTER){
            System.out.println("You can't insert quarter");
        } else if(state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        } else if(state == SOLD_OUT) {
            System.out.println("You can't insert quarter, the machine is sold out");
        } else if(state == SOLD) {
            System.out.println("Please wait, giving you a gumball");
        }
    }

    public void ejectQuarter(){
        if(state == HAS_QUARTER){
            System.out.println("Quarter returned");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        } else if (state == SOLD) {
            System.out.println("Turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("You haven't inserted a quarter yet");
        }
    }

    public void turnCrank(){
        if(state == SOLD){
            System.out.println("Doesn't get you another gumball");
        } else if(state == NO_QUARTER){
            System.out.println("You turned but there's no quarter");
        } else if(state == SOLD_OUT) {
            System.out.println("No gumballs");
        } else if(state == HAS_QUARTER){
            System.out.println("You turned");
            state = SOLD;
            dispense();
        }
    }

    public void dispense(){
        if(state == SOLD){
            System.out.println("Take gumball");
            count--;
            if(count == 0){
                System.out.println("No gumballs");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if(state == NO_QUARTER){
            System.out.println("Need to pay");
        } else if(state == SOLD_OUT){
            System.out.println("No gumballs dispensed");
        } else if(state == HAS_QUARTER){
            System.out.println("No gumballs dispensed");
        }
    }

    @Override
    public String toString() {
        return "MainState{" +
                "count=" + count +
                '}';
    }
}
