public class Solution {
    public boolean isSymmetric(TreeNode root) {
    return root == null ? true : symmetric(root.left, root.right);
}

public boolean symmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
        return true;
    } else if (left != null && right != null && left.val == right.val) {
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    } else {
        return false;
    }
}
}