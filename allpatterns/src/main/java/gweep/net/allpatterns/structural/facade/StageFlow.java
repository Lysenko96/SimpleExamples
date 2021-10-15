package gweep.net.allpatterns.structural.facade;

public class StageFlow {

	Builder builder = new Builder();
	StageTracker stageTracker = new StageTracker();
	Assembly assembly = new Assembly();
	Test test = new Test();

	void assembling() {
		builder.build();
		stageTracker.setResult(assembly.action());
	}

	void testing() {
		builder.build();
		stageTracker.setResult(test.action());
	}
}