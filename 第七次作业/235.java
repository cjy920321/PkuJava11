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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = root;
        if (lca == null)
        {
            return null;
        }
        while ((lca.val < p.val && lca.val < q.val) || (lca.val > p.val && lca.val > q.val))
        {
            if (lca.val < p.val && lca.val < q.val)
            {
                lca = lca.right;
            }
            else
            {
                lca = lca.left;
            }
        }
        return lca;
    }
}