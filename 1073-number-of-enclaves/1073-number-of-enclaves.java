class Solution {
    int n;
    int m;
    public int numEnclaves(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int[][] va=new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(va[i],0);
        }

        for(int i=0;i<m;i++){
            //top border
            if(grid[0][i]==1 && va[0][i]==0){
                DFS(grid,va,0,i);
            }
            // buttom border
            if(grid[n-1][i]==1 && va[n-1][i]==0){
                DFS(grid,va,n-1,i);
            }
        }

        for(int i=0;i<n;i++){
            //left border
            if(grid[i][0]==1 && va[i][0]==0){
                DFS(grid,va,i,0);
            }
            // right border
            if(grid[i][m-1]==1 && va[i][m-1]==0){
                DFS(grid,va,i,m-1);
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && va[i][j]==0){
                    count++;
                }
            }
        }

        return count;
    }
    void DFS(int[][] grid, int[][] va, int r, int c){
        va[r][c]=1;

        int[] drow={0,1,0,-1};
        int[] dcol={-1,0,1,0};
        for(int i=0;i<4;i++){
            int row=r+drow[i];
            int col=c+dcol[i];

            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1 &&va[row][col]==0){
                DFS(grid,va,row,col);
            }
        }
    }
}