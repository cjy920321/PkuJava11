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
        List<Integer> list=new LinkedList<Integer>();
		List<TreeNode> queue=new LinkedList<TreeNode>();
          if(root==null)
		   {
		     return 0;
		   }
        queue.add(root);
        list.add(1);
        while(queue.size()!=0)
        {
            
            if(queue.get(0).left!=null)
            {
                queue.add(queue.get(0).left);
                list.add(list.get(0)+1);
            }
            if(queue.get(0).right!=null)
            {
                queue.add(queue.get(0).right);
                list.add(list.get(0)+1);
            }
            queue.remove(0);
            if(queue.size()!=0)
            {
              list.remove(0);
            }
        }
        return list.get(0);
        
        
        
        
    }
}