class Solution {
    List<Integer> ans=new ArrayList<>();
    void solve(TreeNode root){
        if(root==null) return ;
        solve(root.left);
        solve(root.right);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }
}