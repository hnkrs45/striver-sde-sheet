class Solution {
    class nodeinfo{
        boolean isbst;
        int minval;
        int maxval;
        int sum;
        nodeinfo(boolean isbst, int minval, int maxval, int sum){
            this.isbst=isbst;
            this.minval=minval;
            this.maxval=maxval;
            this.sum=sum;
        }
    }
    int ans=0;
    nodeinfo solve(TreeNode root){
        if(root==null){
            return new nodeinfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        nodeinfo left=solve(root.left);
        nodeinfo right=solve(root.right);
        if(left.isbst && right.isbst && root.val>left.maxval && root.val<right.minval){
            int currsum=left.sum+right.sum+root.val;
            ans=Math.max(ans, currsum);
            int minval=Math.min(root.val, left.minval);
            int maxval=Math.max(root.val, right.maxval);

            return new nodeinfo(true, minval, maxval, currsum);
        }
        return new nodeinfo(false, 0, 0, 0);
    }
    public int maxSumBST(TreeNode root) {
        solve(root);
        return ans;   
    }
}