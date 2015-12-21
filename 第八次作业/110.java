/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if((root.left == null && root.right != null && (root.right.right != null || root.right.left != null)) || (root.right == null && root.left != null && (root.left.right != null || root.left.left != null)))
            return false;
        return(isBalanced(root.left) && isBalanced(root.right) && (Math.abs(deep(root.left) - deep(root.right)) <= 1));
        
    }
    
    public int deep(TreeNode root)
    {
        if (root == null)
            return 0;
        else
            return Math.max(deep(root.left),deep(root.right)) + 1;
            
    }
}