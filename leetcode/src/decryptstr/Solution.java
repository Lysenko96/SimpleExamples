package decryptstr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public String freqAlphabets(String s) {
		String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		List<String> first = new ArrayList<>();
		List<String> second = new ArrayList<>();
		String lElem = "";
		int last = 0;
		String[] arr = s.split("");
		String[] res = new String[] {};
		List<String> l = Arrays.asList(arr);
		if (l.contains("#")) {
			res = s.split("#");
		}
		StringBuilder q = new StringBuilder();
		List<String> newL = new ArrayList<>();
		if (l.get(l.size() - 1).equals("#")) {
			for (int i = 0; i < res.length; i++) {
				first = new ArrayList<>();
				if (res[i].length() > 2) {
					String[] str = res[i].split("");
					Collections.addAll(first, str);
					String lastStr = first.get(first.size() - 2) + first.get(first.size() - 1);
					last = Integer.parseInt(lastStr);
					first.remove(first.size() - 1);
					first.remove(first.size() - 1);
					for (int d = 0; d < first.size(); d++) {
						newL.add(alphabet[Integer.parseInt(first.get(d)) - 1]);
					}
					newL.add(alphabet[last - 1]);
				} else if (res[i].length() <= 2) {
					newL.add(alphabet[Integer.valueOf(res[i]) - 1]);
				}
			}
		} else {
			Collections.addAll(second, res);
			lElem = second.get(second.size() - 1);
		}
		String[] st = lElem.split("");
		for (int f = 0; f < second.size() - 1; f++) {
			if (second.get(f).length() <= 2) {
				newL.add(alphabet[Integer.parseInt(second.get(f)) - 1]);
			} else {
				String last1 = second.get(f).substring(second.get(f).length() - 2, second.get(f).length());
				String sm = second.get(f).substring(0, second.get(f).length() - 2);
				String[] dt = sm.split("");
				for (int b = 0; b < dt.length; b++) {
					newL.add(alphabet[Integer.valueOf(dt[b]) - 1]);
				}
			}
		}

		if (!l.get(l.size() - 1).equals("#")) {
			for (int g = 0; g < st.length; g++) {
				newL.add(alphabet[Integer.parseInt(st[g]) - 1]);
			}
		}
		StringBuilder s1 = new StringBuilder();
		for (int z = 0; z < newL.size(); z++) {
			s1.append(newL.get(z));
		}
		//System.out.println(s1.toString());
		return s1.toString();
	}

	public static void main(String[] args) {
		new Solution().freqAlphabets("26#11#418#5");
	}
}