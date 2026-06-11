
class Solution {

    int merge(int[] arr, int low, int mid, int high){
        int[] temp=new int[high-low+1];
        int left=low;
        int right=mid+1;
        int k=0;
        int cnt=0;
        while(left<=mid && right<=high){
            if(arr[left] <= arr[right]){
                temp[k++]=arr[left++];
            }
            else{
                temp[k++]=arr[right++];
                cnt+=(mid-left+1);
            }
        }
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while(right<=high){
            temp[k++]=arr[right++];
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp[i-low];
        }
        return cnt;
    }

    int mergesort(int[] arr, int low, int high){
        int cnt=0;
        if(low>=high) return cnt;
        int mid=(low+high)/2;
        cnt+=mergesort(arr, low, mid);
        cnt+=mergesort(arr, mid+1, high);
        cnt+=merge(arr, low, mid, high);
        return cnt;
    }

    public int numberofinversions(int[] arr){
        return mergesort(arr, 0, arr.length-1);
    }
}

public class CountInversionsInArray {
    public static void main(String[] args){
        int[] a={5,4,3,2,1};
        IntersectionOfTwoLinkedLists s=new IntersectionOfTwoLinkedLists();
        int cnt = s.numberofinversions(a);
        System.out.println("The number of inversions are: " + cnt);
    }
}