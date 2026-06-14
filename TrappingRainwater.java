class Solution {
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int right[]=new int[height.length];
        int maxtillnow=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            maxtillnow=Math.max(maxtillnow, height[i]);
            left[i]=maxtillnow;
        }
        maxtillnow=Integer.MIN_VALUE;
        for(int i=height.length-1;i>=0;i--){
            maxtillnow=Math.max(maxtillnow, height[i]);
            right[i]=maxtillnow;
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            ans+=(Math.min(left[i], right[i])-height[i]);
        }
        return ans;
    }
}