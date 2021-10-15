package rangesumtree;

import java.util.ArrayList;
import java.util.List;

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
class Solution {
	public int rangeSumBST(TreeNode root, int low, int high) {
		List<Integer> vals = new ArrayList<>();
		List<Integer> result = traverseInOrder(root, vals);
		int sum = 0;
		for (Integer i : result) {
			if (i >= low && i <= high) {
				sum += i;
			}
		}
		return sum;
	}

	public List<Integer> traverseInOrder(TreeNode node, List<Integer> vals) {
		if (node != null) {
			traverseInOrder(node.left, vals);
			vals.add(node.val);
			traverseInOrder(node.right, vals);
		}
		return vals;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)),
				new TreeNode(15, null, new TreeNode(18)));
		System.out.println(solution.rangeSumBST(root, 7, 15));
	}
}
