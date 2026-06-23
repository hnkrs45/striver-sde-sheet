import java.util.*;

class Solution {
    public List<Integer> mergeKSortedArrays(int[][] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=arr.length, m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.offer(arr[i][j]);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr={{1,2,2}, {3,4,5}, {6,2,3}, {7,1,4}};
        Solution sol=new Solution();
        List<Integer> ans=sol.mergeKSortedArrays(arr, 4);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+ " ");
        }
    }
}