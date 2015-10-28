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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> serial= new ArrayList<Integer>();
        List<Boolean> flag = new ArrayList<Boolean>();
        Stack<TreeNode> sk = new Stack<TreeNode>();
        if (root == null)
            return serial;
        while (root!=null && !(sk.isEmpty()))
        {
            while (root!=null)
            {
                sk.push(root);
                flag.add(false);
                root = root.left;
            }
            root = sk.peek();
            if (flag.get(flag.size()-1) == false)
            {
                flag.set(flag.size()-1,true);
                root = root.right;
            }
            else
            {
                serial.add(root.val);
                sk.pop();
                flag.remove(flag.size()-1);
                root = sk.peek();
            }
        }
      return serial;  
    }
}