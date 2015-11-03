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
    public List<Integer> preorderTraversal(TreeNode root)
    {
     
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) return result;    
    stack.push(root);   //���ڵ�ѹջ
    while (!stack.isEmpty()) {  //���ջ�ǿ�
        TreeNode temp = stack.pop();//��ջ
        if (temp != null) {    //�����ջ�Ľڵ㲻��NULL
            result.add(temp.val); //�������Ľ�������
            stack.push(temp.right);//���ҽڵ���ѹջ
            stack.push(temp.left);//����ڵ�ѹջ������while
        }
    }
    return result;
        
    }
}