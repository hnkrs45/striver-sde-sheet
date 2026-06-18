class Solution {
    public boolean issafe(char[][] board,int row,int col,char num){
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num||board[row][i]==num){
                return false;
            }
            else if(board[3*(row/3)+i/3][3*(col/3)+i%3]==num){
                return false;
            }
        }
        return true;

    }
    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(issafe(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board)==false){
                                board[i][j]='.';
                            }
                            else{
                                return true;
                            }
                        }
                    }
                    return false;    
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        boolean ans=solve(board);
    }
}