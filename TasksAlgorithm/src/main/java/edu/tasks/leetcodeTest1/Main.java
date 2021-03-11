package edu.tasks.leetcodeTest1;

public class Main {

	Main() {
		ListNode n3 = new ListNode(3, null);
		ListNode n2 = new ListNode(4, n3);
		ListNode n1 = new ListNode(2, n2);
		ListNode m3 = new ListNode(7, null);
		ListNode m2 = new ListNode(7, m3);
		ListNode m1 = new ListNode(5, m2);
		ListNode z = new ListNode(0);
		ListNode z1 = new ListNode(0);
		System.out.println(addTwoNumbers(n1, m1));
		System.out.println(addTwoNumbers(z, z1));
		System.out.println(n1);
		System.out.println(m1);
	}

	public static void main(String[] args) {
		new Main();
	}

	ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int a = 0;
		int b = 0;
		int c = 0;
		if (l1.getVal() != 0 && l2.getVal() != 0 && l1.getNext() != null && l2.getNext() != null) {
			a = l1.getVal() + l2.getVal();
			if (l1.getVal() + l2.getVal() >= 10) {
				b += 1;
				a = a % 10;
			}
			System.out.println(a);
			b = l1.getNext().getVal() + l2.getNext().getVal();
			if (l1.getNext().getVal() + l2.getNext().getVal() >= 10) {
				c += 1;
				b = b % 10;
			}
			System.out.println(b);
			c += l1.getNext().getNext().getVal() + l2.getNext().getNext().getVal();
			if (l1.getNext().getVal() + l2.getNext().getVal() >= 10) {
				c = c % 10;
			}
			System.out.println(c);
			ListNode t3 = new ListNode(c, null);
			ListNode t2 = new ListNode(b, t3);
			ListNode t1 = new ListNode(a, t2);
			return t1;
		} else
			return new ListNode(0);
	}
}
