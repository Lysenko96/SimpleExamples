package flipmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public int[][] flipAndInvertImage(int[][] image) {

		int[][] arr = new int[image.length][image.length];
		int index = 0;
		for (int i = 0; i < image.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < image[i].length; j++) {
			//	System.out.print(image[i][j]);
				if (image[i][j] == 0) {
					image[i][j] = 1;
				} else if (image[i][j] == 1) {
					image[i][j] = 0;
				}
				list.add(image[i][j]);
			}
			Collections.reverse(list);
			
			for(int j = 0; j < image.length; j++) {
				arr[index][j] = list.get(j);
			}
			index++;
		}
		System.out.println(Arrays.deepToString(arr));
		return arr;
	}

	public static void main(String[] args) {
		new Main().flipAndInvertImage(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } });
	}
}
