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
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return depth;
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        depth++;
        int count = 1;
        while(queue.size() != 0)
        {
            int newcount = 0;
            while(count > 0)
            {
                
                if (queue.get(0).left == null && queue.get(0).right == null)
                    return depth;
                if (queue.get(0).left != null)
                {
                    queue.add(queue.get(0).left);
                    newcount++;
                }
                if (queue.get(0).right != null)
                {
                    queue.add(queue.get(0).right);
                    newcount++;
                }
                queue.remove(0);
                count--;
            }
            count = newcount;
            depth++;
        }
        return depth;
    }
}