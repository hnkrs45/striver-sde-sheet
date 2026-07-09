class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            while(q.peek()!=null){
                Node curr=q.poll();
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                curr.next=q.peek();
            }
            q.poll();
            if(q.size()>0) q.offer(null);
        }
        return root;
    }
}