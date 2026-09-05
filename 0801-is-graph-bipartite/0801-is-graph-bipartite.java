class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[] vis= new int[n];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                 if(!DFS(i,0,vis,graph)) return false;
            }
           
        }

        return true;
    }
    static boolean DFS(int src, int col, int[] vis, int[][] adj){
        vis[src]=col;
        
        for(int  cj: adj[src]){
            
                if(vis[cj]==-1){
                    if(!DFS(cj,1-col,vis, adj)) return false;
                }else if(vis[cj]==vis[src]) return false;
          
        }
        return true;
    }
}