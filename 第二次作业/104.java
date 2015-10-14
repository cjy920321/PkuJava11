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

    while (!de.isEmpty()) {  //������в���
        int size = de.size(); //��ʱ�����е���һ���Ԫ�ظ���
        while (size-- > 0) {
            TreeNode cur = de.pop();
            if (cur.left != null)
                de.addLast(cur.left);
            if (cur.right != null)
                de.addLast(cur.right);
        }
        count++;//��һ���Ԫ�س���������ˣ���Ⱦ�+1

    }
    return count;
        
    }
}