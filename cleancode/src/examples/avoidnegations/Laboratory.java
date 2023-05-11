package examples.avoidnegations;

public class Laboratory {

    Microscope microscope;


    Result analyze(Sample sample){
        if(microscope.isOrganic(sample))
            return analyzeOrganic(sample); // avoid negations conditions
        else
            return Result.INORGANIC;

    }

    private Result analyzeOrganic(Sample sample){
        if(microscope.isHumanoid(sample))
            return Result.HUMANOID; // avoid negations conditions
        else
            return Result.ALIEN;
    }
}

class Microscope {

    public boolean isOrganic(Sample sample){
        return sample.isOrganic();
    }

    public boolean isHumanoid(Sample sample){
        return sample.isHumanoid();
    }
}

enum Result {

    INORGANIC, ALIEN, HUMANOID
}

class Sample {

    private boolean isOrganic;
    private boolean isHumanoid;

    public Sample() {
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean isOrganic) {
        this.isOrganic = isOrganic;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public void setHumanoid(boolean humanoid) {
        isHumanoid = humanoid;
    }
}