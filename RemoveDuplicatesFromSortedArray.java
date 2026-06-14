class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> li=new ArrayList<>();
        li.add(nums[0]);
        int val=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                li.add(nums[i]);
                val=nums[i];
            }
        }
        for(int i=0;i<li.size();i++){
            nums[i]=li.get(i);
        }
        return li.size();
    }
}