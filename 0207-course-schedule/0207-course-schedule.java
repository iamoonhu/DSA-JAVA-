class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> out= new ArrayList<>();
        int[] va= new int[numCourses];
        Arrays.fill(va,0);
        for(int i=0;i<numCourses;i++){
            out.add(new ArrayList<Integer>());
        }

        
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            out.get(prerequisite).add(course);
        }

        for(int i=0;i<numCourses;i++){
            if(DFS(i,va,out)) return false;
        }
        return true;
    }
    static boolean DFS(int src,int[] va, List<List<Integer>> adj){
        if(va[src]==1) return true;

        if(va[src]==2) return false;

        va[src]=1;
        for(int x: adj.get(src)){
            if(DFS(x,va,adj)) return true;
        }

        va[src]=2;

        return false;

    }
}