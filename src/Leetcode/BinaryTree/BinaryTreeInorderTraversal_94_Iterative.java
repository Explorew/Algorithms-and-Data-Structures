package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94_Iterative {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
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
