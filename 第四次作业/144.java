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
        	List<Integer> result=new LinkedList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();//初始化栈
		TreeNode p=root;
		while(p!=null||!stack.isEmpty()){//p不空或栈不空
			if(p!=null){
				result.add(p.val);//访问根节点
				stack.push(p);//访问左子树
				p=p.left;//遍历左子树
			}
			else{
				p=stack.pop();//退栈
				p=p.right;//遍历右子树
			}
		}
		return result;
    }
}