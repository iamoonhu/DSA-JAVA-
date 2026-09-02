class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[][] res= new int[n][m];
        Queue<state> queue= new LinkedList<>();
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;  // mark it visited;
                    queue.add(new state(i,j));
                }else{
                    res[i][j]=-1;  // mark it unvisited;
                }
           }
        }
        int drow[]={1,0,-1,0};
        int dcol[]= {0,-1,0,1};
        while(!queue.isEmpty()){
            state st= queue.peek();
            int ssr= st.sr;
            int ssc= st.sc;
            queue.remove();
            for(int i=0;i<=3;i++){
                int r= ssr+drow[i];
                int c= ssc+dcol[i];
                if(r>=0 && r<n && c>=0 && c<m && res[r][c]==-1){
                   res[r][c]=res[ssr][ssc]+1;
                   queue.add(new state(r,c));
                }
            }
        }
        return res;
    }
}
class state{
    int sr;
    int sc;
    state(int sr, int sc){
        this.sr=sr;
        this.sc=sc;
    }
}