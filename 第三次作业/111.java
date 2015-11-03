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
    public int minDepth(TreeNode root)
    {
    if (root == null)   return 0;
    if (root.left == null)  return minDepth(root.right) + 1; //左子树为空，则找右子树离叶子最短的
    if (root.right == null) return minDepth(root.left) + 1;//右子树为空，则找左子树离叶子最短的
    return Math.min(minDepth(root.left),minDepth(root.right)) + 1;//若左右均不为空，则取小者
  }
		
    
}