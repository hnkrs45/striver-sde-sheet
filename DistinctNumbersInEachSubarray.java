import java.util.*;
class Solution {
    public List<Integer> distinctNumbers(int[] nums, int k) {
        List<Integer> ans=new ArrayList<>();
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<k;i++){
            mp.put(nums[i], i);
        }
        for(int i=k;i<nums.length;i++){
            ans.add(mp.size());
            mp.put(nums[i], i);
            mp.remove(nums[i-k], i-k);
        }
        ans.add(mp.size());
        return ans;
    }
}

public class DistinctNumbersInEachSubarray {
    public static void main(String[] args) {
        Solution s=new Solution();
        int nums[]={1,1,1,1,2,3,4};
        List<Integer> ans=s.distinctNumbers(nums, 4);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}