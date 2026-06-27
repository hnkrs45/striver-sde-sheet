class pair{
    int i;
    int j;
    int time;
    pair(int i, int j, int time){
        this.i=i;
        this.j=j;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        int vis[][]=new int[n][m];
        int countfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i, j, 0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) countfresh++;
            }
        }
        int ans=0, count=0;
        while(!q.isEmpty()){
            int row=q.peek().i;
            int col=q.peek().j;
            int time=q.peek().time;
            ans=Math.max(ans, time);
            q.remove();
            if(row>0 && grid[row-1][col]==1 && vis[row-1][col]==0){
                q.add(new pair(row-1, col, time+1));
                vis[row-1][col]=1;
                count++;
            }
            if(col>0 && grid[row][col-1]==1 && vis[row][col-1]==0){
                q.add(new pair(row, col-1, time+1));
                vis[row][col-1]=1;
                count++;
            }
            if(row<n-1 && grid[row+1][col]==1 && vis[row+1][col]==0){
                q.add(new pair(row+1, col, time+1));
                vis[row+1][col]=1;
                count++;
            }
            if(col<m-1 && grid[row][col+1]==1 && vis[row][col+1]==0){
                q.add(new pair(row, col+1, time+1));
                vis[row][col+1]=1;
                count++;
            }
        }
        if(count!=countfresh) return -1;
        return ans;
    }
}