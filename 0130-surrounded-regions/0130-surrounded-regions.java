class Solution {
    int n;
    int m;
    public void solve(char[][] board) {
         n= board.length;
         m=board[0].length;
        int[][] res= new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(res[i],0);
        }

        //check for top and bottom border
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && res[0][i]==0){
                DFS(res,board,0,i);
            }

            if(board[n-1][i]=='O' && res[n-1][i]==0){
                DFS(res,board,n-1,i);
            }
        }

        //check for right and left border
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && res[i][0]==0){
                DFS(res,board,i,0);
            }

            if(board[i][m-1]=='O' && res[i][m-1]==0){
                DFS(res,board,i,m-1);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && res[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }

    void DFS(int[][] va,char[][] board, int r, int c){
        va[r][c]=1; // visit the cell

        int[] drow={1,0,-1,0};
        int[] dcol={0,1,0,-1};

        for(int i=0;i<4;i++){
            int row=r+drow[i];
            int col=c+dcol[i];

            if(row>=0 && row<n && col>=0 && col<m && board[row][col]=='O' && va[row][col]==0){
                DFS(va,board,row,col);
            }
        }
    }
}