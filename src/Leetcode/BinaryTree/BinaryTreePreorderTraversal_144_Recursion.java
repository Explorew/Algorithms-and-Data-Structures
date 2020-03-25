package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144_Recursion {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
