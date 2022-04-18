package net.pack.tasksnleet.bst;

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
        //System.out.println(new Solution().searchBST(new TreeNode(4, new TreeNode(2), new TreeNode(7)),2));
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));
        System.out.println(new Solution().searchBST(root, 2));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root.val != val){
            root.right = root.right.right;
            root.left = root.left.left;
            System.out.println(root);
        }
        return null;
    }


}
