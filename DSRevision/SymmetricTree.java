public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val))
            return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
