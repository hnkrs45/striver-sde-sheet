public import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] maxOfMin(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()? n: stack.peek();
            stack.push(i);
        }
        int[] result=new int[n+1]; 
        Arrays.fill(result, 0);
        for(int i=0;i<n;i++){
            int len=right[i]-left[i]-1;
            result[len]=Math.max(result[len], arr[i]);
        }
        for(int i=n-1;i>=1;i--){
            result[i]=Math.max(result[i], result[i+1]);
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=result[i+1];
        }
        return ans;
    }
}

public class MaximumOfMinimums {
    public static void main(String[] args) {
        Solution sol=new Solution();
        int arr[]={10, 20, 30, 50, 10, 70, 30};
        arr=sol.maxOfMin(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
} {
    
}
