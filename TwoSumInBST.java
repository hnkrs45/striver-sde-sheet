class Solution {
    Set<Integer> st=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        if(st.contains(k-root.val)) return true;
        st.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}