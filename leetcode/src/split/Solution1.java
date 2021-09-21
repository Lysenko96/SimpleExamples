package split;

public class Solution1 {

	public int balancedStringSplit(String s) {
		int countR = 0;
		int countL = 0;
		int countSplit = 0;
		int index = 0;
		int result = 0;
		String[] litters = s.split("");
		for (String litter : litters) {
			if (litter.equals("R")) {
				countR++;
			} else if (litter.equals("L")) {
				countL++;
			}
			if (countL == countR) {
				countSplit = 1;
				if (countSplit == 1) {
					int temp = index;
					index += countR + countL;
					String s1 = s.substring(temp, index);
					result++;
				}
				countSplit = 0;
				countR = 0;
				countL = 0;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.balancedStringSplit("RLRRLLRLRL"));
	}
}
