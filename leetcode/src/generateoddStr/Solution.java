package generateoddStr;

import java.util.Random;

public class Solution {

	public String generateTheString(int n) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		int value = 0;
		if (n % 2 != 0 && n != 1) {
			value = n - 2;
			String s = "";
			String s1 = "";
			String s2 = "";
			while (true) {
				s = alphabet[rand.nextInt(25)];
				s1 = alphabet[rand.nextInt(25)];
				s2 = alphabet[rand.nextInt(25)];
				if (!s.equals(s1) && !s1.equals(s2) && !s.equals(s2)) {
					break;
				}
			}
			for (int i = 0; i < value; i++) {
				sb.append(s);
			}
			sb.append(s1);
			sb.append(s2);
		} else if (n == 1) {
			String s = "";
			s = alphabet[rand.nextInt(25)];
			sb.append(s);
		} else {
			value = n - 1;
			String s = "";
			String s1 = "";
			while (true) {
				s = alphabet[rand.nextInt(25)];
				s1 = alphabet[rand.nextInt(25)];
				if (!s.equals(s1)) {
					break;
				}
			}
			for (int i = 0; i < value; i++) {
				sb.append(s);
			}
			sb.append(s1);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().generateTheString(1));
	}
}