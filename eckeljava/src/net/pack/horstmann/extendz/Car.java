package net.pack.horstmann.extendz;

public class Car {

    private int speed;

    public int getSpeed() {
        return speed;
    }

     Object getObj(){
        return new Object();
    }

//    public int getSpeed(Car car) {
//        int result = 0;
//        if (car instanceof SportCar) {
//            result = 50 + getSpeed();
//        } else if (car != null) {
//            result = getSpeed();
//        }
//        return result;
//    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Car(int speed){
        this.speed = speed;
    }

    public Car(){

    }
}
