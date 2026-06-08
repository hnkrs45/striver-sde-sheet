import java.util.*;
public class Main {
    static int solve(int[] nums, int k){
        int n=nums.length;
        Map<Integer, Integer> mp=new HashMap<>();
        mp.put(0, 1);
        int curprefix=0;
        int ans=0;
        for(int i=0;i<n;i++){
            curprefix^=nums[i];
            int target=curprefix^k;
            if(mp.containsKey(target)){
                ans+=mp.get(target);
            }
            mp.put(curprefix, mp.getOrDefault(curprefix, 0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={5, 6, 7, 8, 9};
        System.out.println(solve(nums, 5));
    }
}