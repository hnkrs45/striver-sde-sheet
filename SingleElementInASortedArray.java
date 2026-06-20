class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0, r=nums.length-1;
        int ans=-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(mid>0 && nums[mid]==nums[mid-1]){
                if(mid%2==0) r=mid-1;
                else l=mid+1;
            }
            else if(mid<nums.length-1 && nums[mid]==nums[mid+1]){
                if(mid%2!=0) r=mid-1;
                else l=mid+1;
            }
            else{
                ans=nums[mid];
                break;
            }
        }
        return ans;
    }
}