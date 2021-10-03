package te.lesson2.command;

import java.util.ArrayList;
import java.util.List;
// Sender
public class Switch {

	private List<Command> history = new ArrayList<>();

	public void storeAndExecute(Command command) {
		history.add(command);
		command.execute();
	}

	public List<Command> getHistory() {
		return history;
	}

	public void setHistory(List<Command> history) {
		this.history = history;
	}
}