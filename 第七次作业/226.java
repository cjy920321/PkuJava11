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
        TreeNode p=root;
		if(p==null){
			return null;
		}
		if(p.left!=null||p.right!=null){
			TreeNode value=p.left;
			p.left=p.right;
			p.right=value;
		}
		invertTree(p.left);
		invertTree(p.right);
		return root;
    }
}