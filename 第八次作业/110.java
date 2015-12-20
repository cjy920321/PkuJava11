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
	public boolean isBalanced(TreeNode root){
        boolean sign=true;
		if(root==null){
			return true;
		}
        int hl=depth(root.left);
        int hr=depth(root.right);
        if(Math.abs(hl-hr)<2){
        	sign=isBalanced(root.left)&&isBalanced(root.right);
        }
        else{
        	sign=false;
        }
        return sign;
	}
	public int depth(TreeNode root){
		int depth=0;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		Queue<Integer> size=new LinkedList<Integer>();
		if(root==null){
			return 0;
		}
		queue.add(root);
		size.add(1);
		while(!queue.isEmpty()){
			if(queue.peek().left!=null){
				queue.add(queue.peek().left);
				size.add(size.peek()+1);
			}
			if(queue.peek().right!=null){
				queue.add(queue.peek().right);
				size.add(size.peek()+1);
			}
			queue.poll();
			if(queue.isEmpty()){
				depth=size.peek();
			}
			size.poll();
		}
		return depth;
	}
}