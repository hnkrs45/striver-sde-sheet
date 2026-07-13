class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    void pushall(TreeNode node){
        for(; node!=null;st.push(node), node=node.left);
    }
    public BSTIterator(TreeNode root) {
        pushall(root);
    }
    
    public int next() {
        TreeNode temp=st.pop();
        pushall(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */