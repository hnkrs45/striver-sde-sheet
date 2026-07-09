class Solution {
    boolean solve(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        else if(left==null && right!=null) return false;
        else if(right==null && left!=null) return false;
        return left.val==right.val && solve(left.left, right.right) && solve(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left, root.right);        
    }
}