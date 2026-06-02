class Solution {
    void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int s=0, mid=0, e=nums.length-1;
        while(mid<=e){
            if(nums[mid]==0){
                swap(nums, s, mid);
                mid++;
                s++;
            }
            else if(nums[mid]==1) mid++;
            else{
                swap(nums, mid, e);
                e--;
            }
        }
        
    }
}