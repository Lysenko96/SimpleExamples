package net.pack.horstmann.extendz;

import java.util.Calendar;

public class SportCar extends Car {

    private int countDoor;
    //private Car car;

    @Override
    public int getSpeed() {
        return 50 + super.getSpeed();
    }

//    public Car getCar(){
//        return car;
//    }


    public SportCar(int speed) {
        super(speed);
      //  this.car = new Car(speed);
        Calendar calendar;
        countDoor = 2;
    }

    @Override
    public SportCar getObj(){
        return new SportCar();
    }


    public SportCar() {
        countDoor = 2;
    }

    public int getCountDoor() {
        return countDoor;
    }
}
