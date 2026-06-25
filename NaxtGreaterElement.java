class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        int[] great=new int[m];
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=m-1;i>=0;i--){
            mp.put(nums2[i], i);
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=mp.get(nums1[i]);j<m;j++){
                if(nums2[j]>nums1[i]){
                    ans[i]=nums2[j];
                    break;
                }
            }
            if(ans[i]==0) ans[i]=-1;
        }
        return ans;
    }
}