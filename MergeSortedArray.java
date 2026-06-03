class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> li=new ArrayList<>();
        int i=0, j=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                li.add(nums1[i]);
                i++;
            }
            else{
                li.add(nums2[j]);
                j++;
            }
        }
        while(i<m){
            li.add(nums1[i]);
            i++;
        }
        while(j<n){
            li.add(nums2[j]);
            j++;
        }
        for(int k=0;k<li.size();k++){
            nums1[k]=li.get(k);
        }

    }
}