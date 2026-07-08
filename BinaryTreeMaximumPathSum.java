class Solution {
    int ans=-1001;
    int solve(TreeNode root, int temp){
        if(root==null) return 0;
        int left=solve(root.left, temp);
        int right=solve(root.right, temp);
        ans=Math.max(ans, Math.max(left, right)+root.val);
        ans=Math.max(ans, root.val);
        ans=Math.max(ans, left+right+root.val);
        return Math.max(Math.max(left, right)+root.val, root.val);
    }
    public int maxPathSum(TreeNode root) {
        return Math.max(solve(root, 0), ans);
    }
}