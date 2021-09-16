package decimalvalue;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Solution {

	public List<Integer> traverseInOrder(ListNode node, List<Integer> vals) {
		if (node != null) {
			traverseInOrder(node.next, vals);
			vals.add(node.val);
		}
		return vals;
	}

	public int getDecimalValue(ListNode head) {
		List<Integer> result = traverseInOrder(head, new ArrayList<>());
		int sum = 0;
		int index = 0;
		for (int i = result.size() - 1; i >= 0; i--) {
			if (result.get(i) == 1) {
				sum += (int) Math.pow(2, ((result.size() - 1) - index));
			}
			index++;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

		System.out.println(solution.getDecimalValue(head));
	}
}
