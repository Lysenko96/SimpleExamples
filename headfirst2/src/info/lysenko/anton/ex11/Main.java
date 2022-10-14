package info.lysenko.anton.ex11;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Double.parseDouble("M");
//        Car car2 = new Car("Car", 222);
//        Car car = new Car("Car3", 222);
//        car = new Car("Car4", 134);
//        try {
//            FileOutputStream fos = new FileOutputStream("obj.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(car);
//            oos.writeObject(car2);
//            oos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            FileInputStream fis = new FileInputStream("obj.ser");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            Object obj = ois.readObject();
//            Object obj2 = ois.readObject();
//            Car car1 = (Car) obj;
//            Car car3 = (Car) obj2;
//            System.out.println(car1);
//            System.out.println(car3);
//            ois.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    }
}

class Car implements Serializable {

    private static String model;
    private int speed;

    public Car() {
    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
