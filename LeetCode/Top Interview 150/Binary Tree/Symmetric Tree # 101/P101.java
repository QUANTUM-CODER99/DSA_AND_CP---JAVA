/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode leftTreeNode, TreeNode rightTreeNode) {
        if (leftTreeNode == null && rightTreeNode == null) 
            return true;
        
        if (leftTreeNode == null || rightTreeNode == null) 
            return false;
        
        return leftTreeNode.val == rightTreeNode.val && isMirror(leftTreeNode.left, rightTreeNode.right) && isMirror(leftTreeNode.right, rightTreeNode.left);
    }
}
