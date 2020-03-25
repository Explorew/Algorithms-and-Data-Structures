package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145_Iterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(0,root.val);
            if(root.left != null)
                stack.push(root.left);
            if(root.right != null)
                stack.push(root.right);
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
