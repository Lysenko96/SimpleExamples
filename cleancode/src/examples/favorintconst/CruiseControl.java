package examples.favorintconst;

public class CruiseControl {

    static final int STOP_PRESET = 0;
    static final int PLANETARY_SPEED_PRESET = 1;
    static final int CRUISE_SPEED_PRESET = 2;

    static final double STOP_SPEED_KMH = 0;
    static final double PLANETARY_SPEED_KMH = 7667;
    static final double CRUISE_SPEED_KMH = 16944;

    private double targetSpeedKmh;

    void setPreset(int speedPreset) {
        if (speedPreset == CRUISE_SPEED_PRESET) setTargetSpeedKmh(CRUISE_SPEED_KMH);
        else if (speedPreset == PLANETARY_SPEED_PRESET) setTargetSpeedKmh(PLANETARY_SPEED_KMH);
        else if (speedPreset == STOP_PRESET) setTargetSpeedKmh(STOP_SPEED_KMH);

    }

    public void setTargetSpeedKmh(double targetSpeedKmh) {
        this.targetSpeedKmh = targetSpeedKmh;
    }
}
