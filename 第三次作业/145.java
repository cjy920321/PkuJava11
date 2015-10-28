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
        		List<Integer> result=new LinkedList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();//初始化栈
		TreeNode p=root;
		TreeNode r=null;
		while(p!=null||!stack.isEmpty()){//栈不空或p不空
			if(p!=null){//遍历左子树
				stack.push(p);
				p=p.left;
			}
			else{
				p=stack.peek();//根节点
			    if(p.right!=null&&p.right!=r){//右子树未被访问过
					p=p.right;
					stack.push(p);
					p=p.left;
				}
				else{
					p=stack.pop();//退栈
					result.add(p.val);//访问
					r=p;//标记访问的节点
					p=null;//重置p指针
				}
			}
		}
		return result;
    }
}