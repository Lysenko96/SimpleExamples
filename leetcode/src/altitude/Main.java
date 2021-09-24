package altitude;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public int largestAltitude(int[] gain) {
		int[] arr = new int[gain.length + 1];
		arr[0] = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = arr[i] + gain[i];
			arr[i + 1] = temp;
			// System.out.println(arr[i]);
			list.add(arr[i]);
		}
		arr[arr.length - 1] = arr[arr.length - 2] + gain[gain.length - 1];
		list.add(arr[arr.length - 1]);
		// System.out.println(list);
		return Collections.max(list);
	}

	public static void main(String[] args) {
		System.out.println(new Main().largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
	}
}
