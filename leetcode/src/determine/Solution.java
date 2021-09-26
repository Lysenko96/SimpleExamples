package determine;

public class Solution {

	public boolean halvesAreAlike(String s) {
		char[] chars = s.toCharArray();
		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		int indexR = 0;
		int indexL = s.length() - 1;
		while (indexR < s.length() / 2) {
			a.append(chars[indexR]);
			b.append(chars[indexL]);
			indexR++;
			indexL--;
		}
		int countA = 0;
		int countB = 0;
		int size = a.toString().toLowerCase().length();
		char[] charsA = a.toString().toLowerCase().toCharArray();
		char[] charsB = b.toString().toLowerCase().toCharArray();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < vowels.length; j++) {
				if (charsA[i] == vowels[j]) {
					countA++;
				}
				if (charsB[i] == vowels[j]) {
					countB++;
				}
			}
		}
		return countA == countB;

	}

	public static void main(String[] args) {
		System.out.println(new Solution().halvesAreAlike("AbCdEfGh"));
	}
}