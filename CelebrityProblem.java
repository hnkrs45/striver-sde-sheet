import java.util.*;

class Solution {
    public int celebrity(int[][] arr) {
        int n=arr.length;
        boolean temp[]=new boolean[n];
        Arrays.fill(temp, true);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(arr[i][j]==0){
                    if(arr[j][i]==0){ 
                        temp[i]=false;
                        break;
                    }
                }
                else{
                    temp[i]=false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(temp[i]) return i;
        }
        return -1;
    }
}

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] M = {
            {0, 1, 1, 0}, 
            {1, 0, 1, 0}, 
            {0, 0, 0, 0}, 
            {0, 1, 1, 0}
        };
        Solution sol = new Solution(); 
        int ans = sol.celebrity(M);
        System.out.println("The index of the celebrity is: " + ans);
    }
}