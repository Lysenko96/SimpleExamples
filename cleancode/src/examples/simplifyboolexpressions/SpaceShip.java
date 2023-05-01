package examples.simplifyboolexpressions;

public class SpaceShip {

    private Crew crew;
    private FuelTank fuelTank;
    private Hull hull;
    private Navigator navigator;
    private OxygenTank oxygenTank;

    boolean willCrewSurvive(){
        boolean hasEnoughResources = hasEnoughFuel() && hasEnoughOxygen(); // simplify boolean expressions
        return hull.isIntact() && hasEnoughResources;
    }


    private boolean hasEnoughOxygen(){
        return oxygenTank.lastsFor(crew.getSize()) > navigator.getTimeToEarth();
    }

    private boolean hasEnoughFuel(){
        return fuelTank.getFuel() >= navigator.getRequiredFuelToEarth();
    }

}

class Crew {

    private int size;

    public Crew() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class FuelTank {

    private int fuel;

    public FuelTank() {
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}

class Hull {

    private boolean isIntact;

    public Hull() {
    }

    public boolean isIntact(){
        return isIntact;
    }

    public void setIntact(boolean intact) {
        isIntact = intact;
    }
}

class Navigator {

    private int requiredFuelToEarth;
    private int timeToEarth;

    public Navigator() {
    }

    public int getRequiredFuelToEarth() {
        return requiredFuelToEarth;
    }

    public void setRequiredFuelToEarth(int requiredFuelToEarth) {
        this.requiredFuelToEarth = requiredFuelToEarth;
    }

    public int getTimeToEarth() {
        return timeToEarth;
    }

    public void setTimeToEarth(int timeToEarth) {
        this.timeToEarth = timeToEarth;
    }
}

class OxygenTank {

    public OxygenTank() {
    }

    public int lastsFor(int size){
        return size;
    }
}