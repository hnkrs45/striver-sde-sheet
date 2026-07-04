class Solution {
    int mainlevel=-1;
    List<Integer> ans=new ArrayList<>();
    void solve(TreeNode root,int level,List<Integer> ans){
        if(root==null) return ;
        if(mainlevel<level){
            ans.add(root.val);
            mainlevel=Math.max(mainlevel,level);
        }
        solve(root.right,level+1,ans);
        solve(root.left,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        solve(root,0,ans);
        return ans;
    }
}