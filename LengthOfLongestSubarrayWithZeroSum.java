import java.util.*;
public class Main {
    static int solve(int[] nums){
        int n=nums.length;
        int max=0, sum=0;
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==0) max=Math.max(max, i+1);
            else{
                if(mp.containsKey(sum)){
                    max=Math.max(max, i-mp.get(sum));
                }
                else{
                    mp.put(sum, i);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int nums[]={9, -3, 3, -1, 6, -5};
        System.out.println(solve(nums));
    }
}