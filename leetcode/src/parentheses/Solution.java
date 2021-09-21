package parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public String removeOuterParentheses(String s) {
		StringBuilder sb1 = new StringBuilder();
		List<String> strings1 = new ArrayList<>();
		int temp = 0;
		int t = 0;
		int begin = 0;
		int index1 = 0;
		char[] chars = s.toCharArray();
		int count = 0;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				count++;
				sb.append("(");
			} else if (chars[i] == ')') {
				index++;
				sb.append(")");
			}
			int k = 0;
			if (count == index) {
				strings1.clear();
				begin += temp - t;
				t = temp;
				String[] res = sb.toString().split("");
				temp = res.length;
				for (int j = begin; j < temp; j++) {
					k = temp;
					if (temp - begin > 2) {
						strings1.add(res[j]);
					}
				}
				index1 = k - begin;
				if (index1 > 2) {
					strings1.remove(0);
					strings1.remove(strings1.size() - 1);
					index1 += 2;
				}
				for (String str1 : strings1) {
					sb1.append(str1);
				}
			}

		}
		System.out.println(sb1.toString());
		return sb1.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.removeOuterParentheses("(()())(())(()(()))");
	}
}