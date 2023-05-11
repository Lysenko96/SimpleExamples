package examples.favorimmutablestate;

// use final if you don't change link for parameter
public final class Distance {

    private final DistanceUnit unit;
    private final double value;

    public Distance(DistanceUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public static void main(String[] args) {
        Distance toMars = new Distance(DistanceUnit.KILOMETERS, 56_000_000);
        Distance marsToVenus = new Distance(DistanceUnit.LIGHTYEARS, 0.000012656528);
        Distance toVenusViaMars = toMars.add(marsToVenus).convertTo(DistanceUnit.MILES);
        System.out.println(toVenusViaMars);
    }

    Distance add(Distance distance){
        return new Distance(unit, value + distance.convertTo(unit).getValue());
    }

    Distance convertTo(DistanceUnit otherUnit){
        double conversionRate = unit.getConversionRate(otherUnit);
        return new Distance(otherUnit, conversionRate * value);
    }

    public DistanceUnit getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "unit=" + unit +
                ", value=" + value +
                '}';
    }

    private static class DistanceUnit {

        private static DistanceUnit KILOMETERS = new DistanceUnit(56_000_000);
        private static DistanceUnit LIGHTYEARS = new DistanceUnit(0.000012656528);
        private static DistanceUnit MILES = new DistanceUnit(56_000);
        private double conversionRate;

        public DistanceUnit() {
        }

        public DistanceUnit(double conversionRate) {
            this.conversionRate = conversionRate;
        }

        public double getConversionRate(DistanceUnit otherUnit) {
            return otherUnit.getConversionRate() + conversionRate;
        }

        public double getConversionRate() {
            return conversionRate;
        }

        public void setConversionRate(double conversionRate) {
            this.conversionRate = conversionRate;
        }

        @Override
        public String toString() {
            return "DistanceUnit{" +
                    "conversionRate=" + conversionRate +
                    '}';
        }
    }

}




