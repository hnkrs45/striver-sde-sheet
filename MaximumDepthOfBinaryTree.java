class Solution {
    int ans=0;
    void solve(TreeNode root, int size){
        if(root==null) return ;
        ans=Math.max(ans, size);
        if(root.left!=null) solve(root.left, size+1);
        if(root.right!=null) solve(root.right, size+1);
    }
    public int maxDepth(TreeNode root) {
        solve(root, 1);
        return ans;    
    }
}