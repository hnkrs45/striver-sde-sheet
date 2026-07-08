class Solution {
    int index=0;
    TreeNode solve(int[] in, int[] post, int start, int end, Map<Integer, Integer> mp){
        if(start>end) return null;
        int val=post[index--];
        int indexininorder=mp.get(val);
        TreeNode root=new TreeNode(val);
        root.right=solve(in, post, indexininorder+1, end, mp);
        root.left=solve(in, post, start, indexininorder-1, mp);
        return root;
    }
    public TreeNode buildTree(int[] in, int[] post) {
        index=in.length-1;
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<in.length;i++){
            mp.put(in[i], i);
        }
        return solve(in, post, 0, in.length-1, mp);
    }
}