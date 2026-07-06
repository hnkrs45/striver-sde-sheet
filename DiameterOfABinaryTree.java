class Solution {
    int ans=0;
    int solve(TreeNode root, int size){
        if(root==null){
            return 0;
        }
        size++;
        int left=solve(root.left, size);
        int right=solve(root.right, size);
        ans=Math.max(ans, left+right);
        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root, -1);
        return ans;
    }
}