class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> st=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int l=j+1, r=nums.length-1;
                while(l<r){
                    long sum=(long)nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        List<Integer> li=new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[l]);
                        li.add(nums[r]);
                        st.add(li);
                        l++;
                        r--;
                    }
                    else if(nums[i]+nums[j]+nums[l]+nums[r]>target) r--;
                    else l++;
                }
            }
        }
        for(List<Integer> elem: st){
            ans.add(elem);
        }
        return ans;
    }
}