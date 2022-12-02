package info.lysenko.anton.patterns.command;

public class LightControlCommandOn implements Command {

    private Light light;
    private int prevCommand;

    public LightControlCommandOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        prevCommand = light.getCommand();
        light.on();
    }

    //@Override
    public void undo() {
        if (Light.OFF == prevCommand)
            light.off();
        else if (Light.HIGH == prevCommand)
            light.high();
    }

    @Override
    public String toString() {
        return "LightControlCommandOn{" +
                "light=" + light +
                ", prevCommand=" + prevCommand +
                '}';
    }
}
