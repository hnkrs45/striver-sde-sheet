class Solution {
    boolean ans=true;
    int solve(TreeNode root, int size){
        if(ans==false) return 0;
        if(root==null){
            return 0;
        }
        size++;
        int left=solve(root.left, size);
        if(ans==false) return 0;
        int right=solve(root.right, size);
        ans=ans && Math.abs(left-right)<2;
        return Math.max(left, right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        solve(root, -1);
        return ans;
    }
}