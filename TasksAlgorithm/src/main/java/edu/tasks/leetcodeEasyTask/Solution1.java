package edu.tasks.leetcodeEasyTask;

public class Solution1 {

	Solution1() {
		System.out.println(defangIPaddr("192.168.1.1"));// 192[.]168[.]1[.]1
	}

	public static void main(String[] args) {
		new Solution1();
	}

	public String defangIPaddr(String address) {
		String[] symbols = address.split("");
		String newAddr = "";
		for (String s : symbols) {
			if (s.equals(".")) {
				s = "[.]";
			}
			newAddr += s;
		}
		return newAddr;
	}

}
