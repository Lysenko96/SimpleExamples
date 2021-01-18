package edu.mytasks.lysenko;

public class Action implements Playable {

	private Action() {
	}

	public static Action getAction() {
		// spring use scope=singleton 
		return new Action();
	}

	public void init() {
		System.out.println("init bean");
	}

	public void destroy() {
		System.out.println("destroy bean");
	}

	@Override
	public String getGame() {
		return "Action game";
	}

}
