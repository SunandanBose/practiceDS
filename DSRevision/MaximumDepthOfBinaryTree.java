public class MaximumDepthOfBinaryTree {
    
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
    
}
