class Solution {
    int n;
    int m;
    public int numIslands(char[][] grid) {
         n= grid.length;
         m= grid[0].length;

        int[][] vis= new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],0);
        }
        int islands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    islands++;
                    DFS(i,j,grid,vis);
                }
            }
        }
        return islands;
    }
    void DFS(int sr, int sc, char[][] grid, int[][] vis){
        vis[sr][sc]=1;  // visit them
        int [] drow={0,1,0,-1};
        int [] dcol={-1,0,1,0};
        for(int i=0;i<4;i++){
            int row=sr+drow[i];
            int col=sc+dcol[i];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]=='1' && vis[row][col]==0){
                DFS(row,col,grid,vis);
            }
        }
    }
}