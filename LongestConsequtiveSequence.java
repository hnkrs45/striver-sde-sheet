class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        int ans=0;
        for(Integer it: st){
            if(!st.contains(it-1)){
                int count=1;
                int value=it+1;
                while(st.contains(value)){
                    count++;
                    value++;
                }
                ans=Math.max(ans, count);
            }
        }
        return ans;
    }
}