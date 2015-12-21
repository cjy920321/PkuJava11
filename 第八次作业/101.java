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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        TreeNode left = root.left, right = root.right;
        if (left == null || right == null)
            return false;
        Stack<TreeNode> skl = new Stack<TreeNode>();
        Stack<TreeNode> skr = new Stack<TreeNode>();
        while ((left != null || !(skl.isEmpty())) || (right != null || !(skr.isEmpty())))
        {
            while (left!=null && right != null)
            {
                if (left.val != right.val)
                    return false;
                skl.push(left);
                left = left.left;
                skr.push(right);
                right = right.right;
            }
            if (left == null && right == null)
            {
                left = skl.peek();
                skl.pop();
                left = left.right;
                right = skr.peek();
                skr.pop();
                right = right.left;
            }
            else
                return false;
        }
      return true;
    }
}