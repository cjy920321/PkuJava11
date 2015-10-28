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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> serial= new ArrayList<Integer>();
        Stack<TreeNode> sk = new Stack<TreeNode>();
        if (root == null)
            return serial;
        while (root != null || !(sk.isEmpty()))
        {
            while (root!=null)
            {
                serial.add(root.val);
                sk.push(root);
                root = root.left;
            }
            root = sk.peek();
            sk.pop();
            root = root.right;
                
        }
      return serial;  
    }
}