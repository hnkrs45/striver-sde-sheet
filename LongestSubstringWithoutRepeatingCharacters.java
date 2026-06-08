class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp=new HashMap<>();
        int ans=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            char curr=s.charAt(r);
            if(mp.containsKey(curr) && mp.get(curr)>=l){
                l=mp.get(curr)+1;
            }
            mp.put(curr, r);
            ans=Math.max(ans, r-l+1);
        }
        return ans;
    }
}