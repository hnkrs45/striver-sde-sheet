class Solution {
    public int search(int[] nums, int target) {
        int s=0,e=nums.length-1,mid=0;
        mid=(s+e)/2;
        while(s<=e){
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[s]<=nums[mid]){
                if(nums[s]<=target&&target<=nums[mid]){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
            else if(nums[mid]<=nums[e]){
                if(target>=nums[mid]&&target<=nums[e]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
            mid=(s+e)/2;
        }
        return -1;
    }
}