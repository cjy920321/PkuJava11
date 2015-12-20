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
  String s="";
	public boolean isSymmetric(TreeNode root){
	    if(root==null){
	        return true;
	    }
    	String strmedium=medium(root);
    	s="";
    	String strpre=preorder(root);
    	s="";
    	String strdmedium=mediumreverse(root);
    	s="";
    	String strdpre=preorderreverse(root);
    	if(strmedium.equals(strdmedium)&&strpre.equals(strdpre)){
    		return true;
    	}
    	return false;
    }
	public String medium(TreeNode root){
		if(root.left!=null){
		medium(root.left);
		}
		s+=String.valueOf(root.val);
		if(root.right!=null){
		medium(root.right);
		}
		return s;
	}
	public String preorder(TreeNode root){
		s+=String.valueOf(root.val);
		if(root.left!=null){
		preorder(root.left);
		}
		if(root.right!=null){
		preorder(root.right);
		}
		return s;
	}
	public String mediumreverse(TreeNode root){
		if(root.right!=null){
		mediumreverse(root.right);
		}
		s+=String.valueOf(root.val);
		if(root.left!=null){
		mediumreverse(root.left);
		}
		return s;
	}	
	public String preorderreverse(TreeNode root){
		s+=String.valueOf(root.val);
		if(root.right!=null){
		preorderreverse(root.right);
		}
		if(root.left!=null){
		preorderreverse(root.left);
		}
		return s;
	}
}