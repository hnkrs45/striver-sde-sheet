class MinStack {
    Stack<Integer> st;
    Stack<Integer> mini;
    public MinStack() {
        st=new Stack<>();
        mini=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        int newMin=mini.isEmpty()?val: Math.min(val,mini.peek());
        mini.push(newMin);
    }
    
    public void pop() {
        if(!st.isEmpty()) {
            st.pop();
            mini.pop();
        }

    }
    
    public int top() {
        if(!st.empty()) return st.peek();
        return 0;
    }
    
    public int getMin() {
        if(!mini.isEmpty()) return mini.peek();
        return 0;
    }
}