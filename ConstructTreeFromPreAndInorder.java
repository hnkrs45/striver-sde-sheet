class Solution {
    int index=0;
    TreeNode solve(int[] pre, int[] in, int start, int end, Map<Integer, Integer> mp){
        if(start>end) return null;
        int val=pre[index++];
        int indexininorder=mp.get(val);
        TreeNode root=new TreeNode(val);
        root.left=solve(pre, in, start, indexininorder-1, mp);
        root.right=solve(pre, in, indexininorder+1, end, mp);
        return root;
    }
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<in.length;i++){
            mp.put(in[i], i);
        }
        return solve(pre, in, 0, in.length-1, mp);
    }
}