package info.lysenko.anton.patterns.command;

public class LightControlCommandOff implements Command {

    private Light light;
    private int prevCommand;

    public LightControlCommandOff(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        prevCommand = light.getCommand();
        light.off();
    }

    //@Override
    public void undo() {
        if (prevCommand == Light.ON)
            light.on();
        else if (prevCommand == Light.HIGH)
            light.high();
    }

    @Override
    public String toString() {
        return "LightControlCommandOff{" +
                "light=" + light +
                ", prevCommand=" + prevCommand +
                '}';
    }
}
