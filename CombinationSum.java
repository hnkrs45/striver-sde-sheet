class Solution {
    void solve(List<List<Integer>> ans,List<Integer> temp,int[] nums,int remain,int start){
        if(remain<0) return ;
        else if(remain==0) ans.add(new ArrayList<>(temp));
        else{
            for(int i=start;i<nums.length;i++){
                temp.add(nums[i]);
                solve(ans,temp,nums,remain-nums[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        solve(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
}