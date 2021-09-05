package decode;

import java.util.Arrays;

class Solution {

	public int[] decode(int[] encoded, int first) {
		int[] result = new int[encoded.length + 1];
		result[0] = first;
		int temp = first ^ encoded[0];
		result[1] = temp;
		for (int i = 1; i < encoded.length - 1; i++) {
			temp = temp ^ encoded[i];
			result[i + 1] = temp;
		}
		if (encoded.length > 1) {
			temp = temp ^ encoded[encoded.length - 1];
			result[result.length - 1] = temp;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.decode(new int[] { 6 }, 1)));
	}
}