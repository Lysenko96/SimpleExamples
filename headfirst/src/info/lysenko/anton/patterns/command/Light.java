package info.lysenko.anton.patterns.command;

public class Light {

    public static final int OFF = 0;
    public static final int ON = 1;
    public static final int HIGH = 2;
    private int command = Light.OFF;

    public void on(){
        System.out.println("Light on");
        command = Light.ON;
    }

    public void off(){
        System.out.println("Light off");
        command = Light.OFF;
    }

    public void high(){
        System.out.println("Light high");
        command = Light.HIGH;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "Light{" +
                "command=" + command +
                '}';
    }
}
