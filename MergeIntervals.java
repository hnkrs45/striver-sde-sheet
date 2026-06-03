class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int n=intervals.length;
        List<List<Integer>> ans=new ArrayList<>();
        boolean lastcompleted=false;
        for(int i=0;i<n-1;i++){
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i+1][0]=Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1]=Math.max(intervals[i][1], intervals[i+1][1]);
            }
            else{
                ans.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
                if(i==n-1) lastcompleted=true;
            }
        }
        if(!lastcompleted) {
            ans.add(new ArrayList<>(List.of(intervals[n-1][0], intervals[n-1][1])));
        }
        int res[][]=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i][0]=ans.get(i).get(0);
            res[i][1]=ans.get(i).get(1);
        }
        return res;
    }
}