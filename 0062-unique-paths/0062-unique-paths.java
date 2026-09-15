class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return DFS(dp,0, 0, m, n);
    }

    static int DFS(int[][] dp, int row, int col, int m, int n) {

        
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row >= m || col >= n) {
            return 0;
        }
       
        if(dp[row][col]!=-1) return dp[row][col];


        int down= DFS(dp,row+1,col,m,n);
        int right=DFS(dp,row,col+1,m,n);

        dp[row][col]=down+right;

        return dp[row][col];
    }
}