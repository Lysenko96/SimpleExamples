package edu.mytasks.lysenko;

public class Strategy implements Playable {

	public void init() {
		System.out.println("init bean prototype");
	}

	public void destroy() {
		System.out.println("destroy bean prototype");
	}

	@Override
	public String getGame() {
		return "Strategy game";
	}
}
