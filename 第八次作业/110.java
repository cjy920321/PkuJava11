public class Solution {
  public boolean isBalanced(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    if(root != null)
        q.offer(root);
    while(!q.isEmpty()) {
        TreeNode node = q.poll();
        if(node.left != null)
            q.offer(node.left);
        if(node.right != null)
            q.offer(node.right);
        if(Math.abs(depth(node.left) - depth(node.right)) > 1)
            return false;
    }
    return true;
}

private int depth(TreeNode root) {
    if(root == null)
        return 0;
    return Math.max(depth(root.left), depth(root.right)) + 1;
}
}