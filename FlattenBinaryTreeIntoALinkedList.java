class Solution {
    TreeNode tail;
    public void flatten(TreeNode root) {
        if(root==null) return ;
        TreeNode curr=root.right;
        tail=root;
        flatten(root.left);
        if(root.left!=null){
            root.right=root.left;
            root.left=null;
            tail.right=curr;
        }
        flatten(curr);
    }
}