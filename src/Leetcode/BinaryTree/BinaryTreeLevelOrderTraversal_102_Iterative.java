package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102_Iterative {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            list.add(new ArrayList<Integer>());
            int counter = queue.size();
            for(int i = 0; i<counter; i++){
                root = queue.remove();
                list.get(level).add(root.val);
                if(root.left !=  null)
                    queue.add(root.left);
                if(root.right != null)
                    queue.add(root.right);
            }
            level++;
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
