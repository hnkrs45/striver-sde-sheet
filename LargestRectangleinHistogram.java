class pair{
    int index;
    int height;
    pair(int i, int h){
        this.index=i;
        this.height=h;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<pair> st = new Stack<pair>();
        int ans=0;
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!st.isEmpty() && st.peek().height>heights[i]){
                pair p = st.pop();
                ans=Math.max(ans,p.height*(i-p.index));
                start=p.index;
            }
            st.add(new pair(start,heights[i]));
        }
        while(!st.isEmpty()){
            pair p=st.pop();
            ans = Math.max(ans, p.height* (heights.length-p.index));
        }
        return ans;
    }
}