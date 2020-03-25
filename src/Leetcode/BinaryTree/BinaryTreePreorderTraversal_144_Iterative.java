package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144_Iterative {

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
