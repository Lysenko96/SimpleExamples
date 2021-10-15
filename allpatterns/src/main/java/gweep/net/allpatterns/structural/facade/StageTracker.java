package gweep.net.allpatterns.structural.facade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageTracker {

	private String result;

	public void setResult(String result) {
		this.result = result;
		if (result.equalsIgnoreCase("assembly")) {
			System.out.println("Assembly in active...");
		} else if (result.equalsIgnoreCase("test")) {
			System.out.println("Test in active...");
		}
	}
}