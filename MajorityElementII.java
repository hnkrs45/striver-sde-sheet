class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int elem1=Integer.MIN_VALUE, elem2=Integer.MIN_VALUE;
        int count1=0, count2=0, mini=n/3;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(elem2!=nums[i] && count1==0){
                elem1=nums[i];
                count1++;
            }
            else if(elem1!=nums[i] && count2==0){
                elem2=nums[i];
                count2++;
            }
            else if(elem1==nums[i]) count1++;
            else if(elem2==nums[i]) count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==elem1) count1++;
            else if(nums[i]==elem2) count2++;
        }
        if(count1>mini) ans.add(elem1);
        if(count2>mini) ans.add(elem2);
        return ans;
    }
}