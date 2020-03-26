package Leetcode.BinaryTree;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        return recursion(preorder, inorder, 0, 0, preorder.length-1);
    }

    public TreeNode recursion(int[] preorder, int[] inorder, int preStart, int inorderStart, int inorderEnd){
        if(preStart > preorder.length || inorderStart > inorderEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int counter = inorderStart;
        while(counter <= inorderEnd){
            if(inorder[counter] == preorder[preStart])
                break;
            counter++;
        }
        node.left = recursion(preorder, inorder, preStart+1, inorderStart, counter-1);
        node.right = recursion(preorder, inorder, preStart+counter-inorderStart+1, counter+1, inorderEnd);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
