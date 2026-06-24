class MyStack {
    int size;
    Queue<Integer> st;
    public MyStack() {
        st=new LinkedList<>();
        size=0; 
    }
    
    public void push(int x) {
        st.offer(x);
        size++;
        int temp=0;
        for(int i=1;i<size;i++){
            temp=st.poll();
            st.offer(temp);
        }
    }
    
    public int pop() {
        size--;
        return st.poll();
    }
    
    public int top() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */