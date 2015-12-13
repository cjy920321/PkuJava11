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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
        {
            return null;
        }
        List<TreeNode> invert = new LinkedList<TreeNode>();
        invert.add(root);
        while (invert.size() != 0)
        {
            if (invert.get(0).left != null)
            {
                invert.add(invert.get(0).left);
            }
            if (invert.get(0).right != null)
            {
                invert.add(invert.get(0).right);
            }
            TreeNode node = invert.get(0).right;
            invert.get(0).right = invert.get(0).left;
            invert.get(0).left = node;
            invert.remove(0);
        }
        return root;
    }
}