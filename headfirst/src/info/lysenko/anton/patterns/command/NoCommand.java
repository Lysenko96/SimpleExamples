package info.lysenko.anton.patterns.command;

public class NoCommand implements Command {

    @Override
    public void execute() {

    }

    //@Override
    public void undo() {

    }

    @Override
    public String toString() {
        return "NoCommand{}";
    }
}
