class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean check=false;
        while(!q.isEmpty()){
            int k=q.size();
            List<Integer> li=new ArrayList<>();
            while(k>0){
                TreeNode node=q.poll();
                li.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                k--;
            }
            check=!check;
            if(!check){
                Collections.reverse(li);
            }
            ans.add(li);
        }        
        return ans;
    }
}