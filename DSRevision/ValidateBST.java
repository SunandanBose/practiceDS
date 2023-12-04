// https://leetcode.com/problems/validate-binary-search-tree

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, Long minValue, Long maxValue) {
        if( root != null ) {
            if(root.val <= minValue || root.val >= maxValue)
                 return false;
              return isValidBST(root.left, (long) minValue, (long) root.val) && isValidBST(root.right, (long) root.val, (long) maxValue);
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}