class Solution {
    int solve(char ch){
        if(ch=='I') return 1;
        else if(ch=='V') return 5;
        else if(ch=='X') return 10;
        else if(ch=='L') return 50;
        else if(ch=='C') return 100;
        else if(ch=='D') return 500;
        return 1000;
    }
    public int romanToInt(String s) {
        int i=0;
        int ans=0;
        while(i<s.length()-1){
            int si=solve(s.charAt(i));
            int siplus1=solve(s.charAt(i+1));
            if(si<siplus1)
                ans-=si;
            else
                ans+=si;    
            i++;
        }
        ans+=solve(s.charAt(i));
        return ans;
    }
}