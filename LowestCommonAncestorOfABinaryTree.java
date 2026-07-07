class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode LeftAns=lowestCommonAncestor(root.left,p,q);
        TreeNode RightAns=lowestCommonAncestor(root.right,p,q);
        if(LeftAns==null&&RightAns!=null){
            return RightAns;
        }
        else if(RightAns==null&&LeftAns!=null){
            return LeftAns;
        }
        else if(RightAns!=null&&LeftAns!=null){
            return root;
        }
        else{
            return null;
        }
    }
}