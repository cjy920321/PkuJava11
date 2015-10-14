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
    public int maxDepth(TreeNode root) {
        if (root == null)
        return 0;

    Deque<TreeNode> de = new LinkedList<TreeNode>();

    de.push(root);
    int count = 0;

    while (!de.isEmpty()) {  //如果队列不空
        int size = de.size(); //此时队列中的这一层的元素个数
        while (size-- > 0) {
            TreeNode cur = de.pop();
            if (cur.left != null)
                de.addLast(cur.left);
            if (cur.right != null)
                de.addLast(cur.right);
        }
        count++;//这一层的元素出队列完成了，深度就+1

    }
    return count;
        
    }
}