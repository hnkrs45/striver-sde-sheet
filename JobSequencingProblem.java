import java.util.*;

class Job {
    int id;    
    int dead;  
    int profit; 
}

class Solution {
    public static boolean comparison(Job a, Job b){
        return a.profit>b.profit; 
    }

    public static Pair<Integer, Integer> JobScheduling(Job[] arr, int n){
        Arrays.sort(arr, (a, b) -> b.profit-a.profit);
        int maxi=arr[0].dead;
        for(int i=1; i<n; i++){
            maxi = Math.max(maxi, arr[i].dead); 
        }
        int[] slot = new int[maxi+1];
        Arrays.fill(slot,-1);  
        int countJobs=0, jobProfit=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].dead;j>0;j--){
                if (slot[j]==-1){  
                    slot[j]=i;  
                    countJobs++;   
                    jobProfit+=arr[i].profit;  
                    break;
                }
            }
        }
        return new Pair<>(countJobs, jobProfit);
    }
}

public class JobSequencingProblem {
    public static void main(String[] args){
        int n=4;
        Job[] arr=new Job[]{
            new Job() {{id=1; dead=4; profit=20;}},
            new Job() {{id=2; dead=1; profit=10;}},
            new Job() {{id=3; dead=2; profit=40;}},
            new Job() {{id=4; dead=2; profit=30;}}
        };
        Pair<Integer, Integer> ans = Solution.JobScheduling(arr, n);
        System.out.println(ans.getKey() + " " + ans.getValue());
    }
}