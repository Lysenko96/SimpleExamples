package doingtime;


// don't undestand
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().busyStudent(new int[] { 4 }, new int[] { 4 }, 5));
	}

	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

		int count = 0;
		for (int i = 0; i < endTime.length; i++) {
			if (endTime[i] - startTime[i] >= queryTime) {
				count++;
			}
		}
		return count;
	}
}