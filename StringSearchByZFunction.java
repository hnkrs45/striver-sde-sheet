import java.util.*;

class Solution {
    public int[] computeZArray(String s){
        int n=s.length();
        int[] z=new int[n];
        int left=0, right=0;
        for(int i=1;i<n;i++){
            if(i<=right)
                z[i]=Math.min(right-i+1, z[i-left]);
            while(i+z[i]<n && s.charAt(z[i])==s.charAt(i+z[i]))
                z[i]++;
            if(i+z[i]-1>right){
                left=i;
                right=i+z[i]-1;
            }
        }
        return z;
    }

    public List<Integer> zFunctionSearch(String text, String pattern){
        String combined=pattern + "$" + text;
        int[] z=computeZArray(combined);
        List<Integer> result=new ArrayList<>();
        for(int i=pattern.length()+1;i<combined.length();i++){
            if(z[i]==pattern.length()){
                result.add(i-pattern.length()-1);
            }
        }
        return result;
    }
}

public class StringSearchByZFunction{
    public static void main(String[] args){
        String text="ababcababc";
        String pattern="abc";
        Solution sol=new Solution();
        List<Integer> indices=sol.zFunctionSearch(text, pattern);
        System.out.print("Pattern found at indices: ");
        for(int idx: indices){
            System.out.print(idx + " ");
        }
        System.out.println();
    }
}
