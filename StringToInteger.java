class Solution {
    public int myAtoi(String s) {
        if(s.isEmpty() || s.equals("-") || s.equals("+")) return 0;
        int i=0, n = s.length();
        while(i<n && s.charAt(i)==' ') i++;
        if(i == n) return 0;
        int sign = 1;
        if(s.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(i)=='+'){
            i++;
        }
        long ans=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            ans*=10;
            ans+=(s.charAt(i)-'0');
            if(ans>Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
            else if(-ans<Integer.MIN_VALUE && sign == -1) return Integer.MIN_VALUE; 
            i++;
        }
        return (int) ans*sign;
    }
}