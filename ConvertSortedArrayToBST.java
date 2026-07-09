class Solution {
    TreeNode solve(int[] nums, int s, int e){
        if(s>e) return null;
        int mid=(s+e)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=solve(nums, s, mid-1);
        root.right=solve(nums, mid+1, e);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        return solve(nums, 0, n-1);
    }
}