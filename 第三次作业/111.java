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
    public int minDepth(TreeNode root) {
        	Queue<TreeNode> queue=new LinkedList<TreeNode>();//队列
		Queue<Integer> list=new LinkedList<Integer>();//层队列
		int minDepth=0;
		if(root==null){//根为空
			return 0;
		}
		queue.offer(root);//入队
		list.offer(1);//入队
		while(queue.size()!=0){
			if(queue.peek().left!=null){
				queue.offer(queue.peek().left);
				list.offer(list.peek()+1);
			}
			if(queue.peek().right!=null){
				queue.offer(queue.peek().right);
				list.offer(list.peek()+1);
			}
			if(queue.peek().left==null&&queue.peek().right==null){//最小层的情况
				minDepth=list.peek();
				break;
			}
			queue.poll();
			list.poll();	
		}
		return minDepth;//返回
    }
}