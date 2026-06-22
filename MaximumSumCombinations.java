import java.util.*;

class Solution {
    public List<Integer> maxCombinations(int[] nums1, int[] nums2, int k){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b)-> b[0]-a[0]);
        Set<String> visited = new HashSet<>();
        maxHeap.offer(new int[]{nums1[n-1] + nums2[n-1], n-1, n-1});
        visited.add((n-1)+","+(n-1));
        List<Integer> result=new ArrayList<>();
        while(k-->0 && !maxHeap.isEmpty()){
            int[] current=maxHeap.poll();
            int sum=current[0], i=current[1], j=current[2];
            result.add(sum);
            if(i-1>=0){
                String key1=(i-1)+","+j;
                if (!visited.contains(key1)) {
                    maxHeap.offer(new int[]{nums1[i-1]+nums2[j], i-1, j});
                    visited.add(key1);
                }
            }
            if(j-1>=0){
                String key2=i+","+(j-1);
                if(!visited.contains(key2)) {
                    maxHeap.offer(new int[]{nums1[i] + nums2[j-1], i, j-1});
                    visited.add(key2);
                }
            }
        }

        return result;
    }
}

public class MaximumSumCombinations{
    public static void main(String[] args){
        Solution obj=new Solution();
        int[] nums1={7, 3};
        int[] nums2={1, 6};
        int k=2;
        System.out.println(obj.maxCombinations(nums1, nums2, k));
    }
}
