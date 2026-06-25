class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack();
        for(Character ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[')
                st.add(ch);
            else if(ch==')' && !st.isEmpty() && st.peek()=='('){
                st.pop();
            }
            else if(ch=='}' && !st.isEmpty() && st.peek()=='{'){
                st.pop();
            }
            else if(ch==']' && !st.isEmpty() && st.peek()=='['){
                st.pop();
            }
            else return false;
        }
        if(st.isEmpty()) return true;
        return false;
    }
}