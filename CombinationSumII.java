class Solution {
    void solve(List<List<Integer>> ans, List<Integer> temp, int target, int index, int[] candidates){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target) break;
            temp.add(candidates[i]);
            target-=candidates[i];
            solve(ans, temp, target, i+1, candidates);
            target+=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        solve(ans, temp, target, 0, candidates);
        return ans;
    }
}