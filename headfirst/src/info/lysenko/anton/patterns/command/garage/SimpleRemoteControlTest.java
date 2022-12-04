package info.lysenko.anton.patterns.command.garage;

public class SimpleRemoteControlTest {

    public static void main(String[] args) {
        Garage garage = new Garage();
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garage);
        SimpleRemoteControl remote = new SimpleRemoteControl();

        remote.setCommand(garageDoorOpen);
        remote.buttonWasPressed();
    }
}
