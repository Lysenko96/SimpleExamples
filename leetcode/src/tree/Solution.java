package tree;

import java.util.ArrayList;
import java.util.List;
// need solve

public class Solution {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

		return null;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2, null, null));
		TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
				new TreeNode(3, null, new TreeNode(7)));
		List<Integer> first = solution.traverseInOrder(root, new ArrayList<>());
		List<Integer> second = solution.traverseInOrder(root2, new ArrayList<>());
		int size = 0;
		if (first.size() > second.size()) {
			size = first.size();
			for (int i = second.size(); i < first.size(); i++) {
				second.add(0);
			}
		} else {
			size = second.size();
			for (int i = first.size(); i < second.size(); i++) {
				first.add(0);
			}
		}
		List<Integer> res = new ArrayList<>();
//		System.out.println(first);
//		System.out.println(second);
		for (int i = 0; i < size; i++) {
			if (first.get(i) == null && second.get(i) == null) {
				first.set(i, 0);
				second.set(i, 0);
			} else if (first.get(i) == null) {
				first.set(i, 0);
			} else if (second.get(i) == null) {
				second.set(i, 0);
			}
			res.add(first.get(i) + second.get(i));
		}
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == 0) {
				res.set(i, null);
			}
		}
		System.out.println(res);
	}

	public List<Integer> traverseInOrder(TreeNode node, List<Integer> vals) {
		if (node != null) {
			vals.add(node.val);
			traverseInOrder(node.left, vals);
			traverseInOrder(node.right, vals);
		} else {
			vals.add(null);
		}
		return vals;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}