import java.util.*;

class Solution {
    public int[] nextSmallerElement(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans, -1);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr={1, 3, 2, 4};
        Solution sol=new Solution();
        int[] ans=sol.nextSmallerElement(arr);
        System.out.print("The next smaller elements are: ");
        for(int val: ans){
            System.out.print(val+" ");
        }
    }
}