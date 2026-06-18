class Solution {
    List<List<String>> ans=new ArrayList<>();
    void generate(char[][] board, int row){
        if(row==board.length){
            List<String> li=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                li.add(new String(board[i]));
            }
            ans.add(li);
            return ;
        }
        for(int col=0;col<board[row].length;col++){
            if(issafe(board, row, col)){
                board[row][col]='Q';
                generate(board, row+1);
                board[row][col]='.';
            }
        }
    }
    boolean issafe(char[][] board, int row, int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        int maxleft=Math.min(row, col);
        for(int i=1;i<=maxleft;i++){
            if(board[row-i][col-i]=='Q') return false;
        }
        int maxright=Math.min(row, board.length-1-col);
        for(int i=1;i<=maxright;i++){
            if(board[row-i][col+i]=='Q') return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        generate(board, 0);
        return ans;
    }
}