package info.lysenko.anton.patterns.command.garage;

public class GarageDoorOpenCommand implements Command {

    private Garage garage;

    public GarageDoorOpenCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.up();
    }
}
