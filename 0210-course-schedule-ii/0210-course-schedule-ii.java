class Solution {
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        int n=numCourses;
        // making of adjacency list
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] x: prerequisites){
            int c=x[0];
            int p=x[1];

            adj.get(p).add(c);
        }

        index=n-1;

        int [] out= new int[n];
        int [] va= new int[n];
        for(int i=0;i<n;i++){
            if(!DFS(i,va,adj,out)){
                return new int[0];
            }
        }

        return out;
    }

    boolean DFS(int src, int[] va, List<List<Integer>> adj, int[] out){
        if(va[src]==1){
            return false;
        }

        if(va[src]==2){
            return true;
        }

        //this corse is on path
        va[src]=1;

        for(int i: adj.get(src)){
            if(!DFS(i,va,adj,out)){
                return false;
            }
        }

        //this course is completed
        va[src]=2;

        //and now add it to cousre list 
        out[index--]=src;
        return true;   
    }
}