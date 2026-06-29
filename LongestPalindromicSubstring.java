class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int startindex=-1;
        int len=0;
        for(int i=0;i<n;i++){
            int l=i;
            int r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>len){
                    startindex=l;
                    len=r-l+1;
                }
                l-=1;
                r+=1;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>len){
                    startindex=l;
                    len=r-l+1;
                }
                l-=1;
                r+=1;
            }   
        }
        return s.substring(startindex, startindex+len);
    }
}