package net.gweep.practice;

import java.util.HashMap;
import java.util.Map;

public class District {

	private Map<Party, Integer> votes = new HashMap<>();

	public Map<Party, Integer> getVotes() {
		return votes;
	}

	public void setVotes(Map<Party, Integer> votes) {
		this.votes = votes;
	}
}
