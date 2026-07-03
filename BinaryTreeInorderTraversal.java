class Solution {
    List<Integer> ans=new ArrayList<>();
    void solve(TreeNode root){
        if(root==null) return ;
        solve(root.left);
        ans.add(root.val);
        solve(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }
}