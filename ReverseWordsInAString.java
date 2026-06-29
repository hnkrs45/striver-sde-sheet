class Solution {
    public String reverseWords(String s) {
        Stack<StringBuffer> st=new Stack();
        int n=s.length();
        int i=0;
        while(i<n){
            while(i<n && s.charAt(i)==' ') i++;
            StringBuffer sb=new StringBuffer();
            int j=i;
            while(j<n && s.charAt(j)!=' '){
                sb.append(s.charAt(j));
                j++;
            }
            if(!sb.isEmpty()) st.add(sb);
            i=j;
        }
        StringBuffer sb=new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(' ');
        }
        return sb.toString().substring(0, sb.length()-1);
    }
}