import java.util.*;
class Solution{
    int kthLargestElement(int[] nums, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
public class KthLargestNumber {
    public static void main(String[] args) {
        int[] nums = {-5, 4, 1, 2, -3};
        int k = 3;
        Solution sol = new Solution(); 
        int ans = sol.kthLargestElement(nums, k);
        System.out.println("The Kth largest element in the array is: " + ans);
    }
}