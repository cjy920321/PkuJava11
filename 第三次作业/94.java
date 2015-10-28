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
    public List<Integer> inorderTraversal(TreeNode root) {
        	List<Integer> result=new LinkedList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();//初始化栈
		TreeNode p=root;
		while(p!=null||!stack.isEmpty()){//栈不空时且p不空时循环
			if(p!=null){//根指针进栈，遍历左子树
				stack.push(p);//每遇到非空二叉树先向左走
				p=p.left;
				
			}else{
				p=stack.pop();//退栈，
				result.add(p.val);//访问根节点
				p=p.right;//向右子树走
			}
		}
		return result;
    }
}