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
    stack.push(root);   //根节点压栈
    while (!stack.isEmpty()) {  //如果栈非空
        TreeNode temp = stack.pop();//出栈
        if (temp != null) {    //如果出栈的节点不是NULL
            result.add(temp.val); //便利出的结果添加先
            stack.push(temp.right);//把右节点先压栈
            stack.push(temp.left);//把左节点压栈，继续while
        }
    }
    return result;
        
    }
}