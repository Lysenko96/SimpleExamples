package net.pack.horstmann.extendz;

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
        countDoor = 2;
    }


    public SportCar() {
        countDoor = 2;
    }
}
