class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int size=1;
        List<List<Integer>> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int k=0;
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode elem=q.poll();
                temp.add(elem.val);
                if(elem.left!=null){
                    k++;
                    q.offer(elem.left);
                }
                if(elem.right!=null){
                    k++;
                    q.offer(elem.right);
                }
            }
            ans.add(temp);
            size=k;
        }
        return ans;
    }
}