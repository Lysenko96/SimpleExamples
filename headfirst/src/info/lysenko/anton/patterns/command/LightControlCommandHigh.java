package info.lysenko.anton.patterns.command;

public class LightControlCommandHigh implements Command {

    private Light light;
    private int prevCommand;

    public LightControlCommandHigh(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        prevCommand = light.getCommand();
        light.high();
    }

    //@Override
    public void undo() {
        if (prevCommand == Light.OFF)
            light.off();
        else if (prevCommand == Light.ON)
            light.on();
    }

    @Override
    public String toString() {
        return "LightControlCommandHigh{" +
                "light=" + light +
                ", prevCommand=" + prevCommand +
                '}';
    }
}
