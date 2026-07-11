class Solution {
    List<Integer> li=new ArrayList<>();
    void solve(TreeNode root){
        if(root==null) return ;
        solve(root.left);
        li.add(root.val);
        solve(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        solve(root);
        for(int i=0;i<li.size()-1;i++){
            if(li.get(i)>=li.get(i+1)) return false;
        }
        return true;
    }
}