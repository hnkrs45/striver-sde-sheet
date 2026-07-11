class Solution {
    int index=0;
    TreeNode solve(int[] preorder, int[] inorder, int s, int e){
        if(s>e) return null;
        int val=preorder[index++];
        TreeNode root=new TreeNode(val);
        int idx=s;
        for(int i=s;i<=e;i++){
            if(inorder[i]==val){
                idx=i;
                break;
            }
        }
        root.left=solve(preorder, inorder, s, idx-1);
        root.right=solve(preorder, inorder, idx+1, e);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int[] inorder=new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=preorder[i];
        }
        Arrays.sort(inorder);
        return solve(preorder, inorder, 0, n-1);              
    }
}