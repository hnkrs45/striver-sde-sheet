class Solution {
    int count=0, temp=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        int left=kthSmallest(root.left, k);
        if(left!=0) return left;
        count++;
        if(count==k) return root.val;
        int right=kthSmallest(root.right, k);
        if(right!=0) return right;
        return 0;
    }

    public int kthLargest(TreeNode root, int k) {
        if(root==null) return 0;
        int right=kthLargest(root.right, k);
        if(right!=0) return right;
        temp++;
        if(temp==k) return root.val;
        int left=kthLargest(root.left, k);
        if(left!=0) return left;
        return 0;
    }
}
