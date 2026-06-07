class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n=nums.length;
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            if(mp.getOrDefault(target-nums[i],-1)!=-1){
                ans[0]=i;
                ans[1]=mp.get(target-nums[i]);
                break;
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return ans;
    }
}