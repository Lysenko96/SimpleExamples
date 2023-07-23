package net.pack.leetcodestyle.sumdeepleaves;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().deepestLeavesSum(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), new TreeNode(9)), new TreeNode(5, new TreeNode(13), null)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))))));
    }

    public int deepestLeavesSum(TreeNode root) {
        int deep = height(root, 0, new ArrayList<>());
        return deepestSum(root, 0, 0, deep);
    }

    public int deepestSum(TreeNode root, int sum, int height, int deep) {
        height++;
        if (height == deep) sum += root.val;
        if (root.left != null) sum = deepestSum(root.left, sum, height, deep);
        if (root.right != null) sum = deepestSum(root.right, sum, height, deep);
        return sum;
    }

    public int height(TreeNode root, int height, List<Integer> list) {
        height++;
        list.add(height);
        if (root.left != null) height(root.left, height, list);
        if (root.right != null) height(root.right, height, list);
        return Collections.max(list);
    }
}