package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94_Recursion {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left != null)
            inorderTraversal(root.left);
        list.add(root.val);
        if(root.right != null)
            inorderTraversal(root.right);
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
