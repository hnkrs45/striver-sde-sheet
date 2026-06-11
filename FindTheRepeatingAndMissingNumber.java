class Solution{
    public int[] solve(int arr[]){
        int count[]=new int[arr.length];
        int[] ans=new int[2];
        for(int i=0;i<arr.length;i++){
            count[arr[i]-1]++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]==0){
                ans[1]=i+1;
            }
            if(count[i]==2){
                ans[0]=i+1;
            }
        }
        return ans;
    }
}
public class FindTheRepeatingAndMissingNumber {
    public static void main(String args[]){
        int arr[]={3,1,2,5,3};
        LinkedListCycle s=new LinkedListCycle();
        int ans[]=s.solve(arr);
        System.out.println("Duplicate: "+ ans[0] +" Missing: " + ans[1]);
    }
}