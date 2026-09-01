class Solution {

    static class State {
        int row;
        int col;
        int energy;
        int mask;
        int moves;

        State(int row, int col, int energy, int mask, int moves) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int sr = 0, sc = 0;

        int[][] litterIndex = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(litterIndex[i], -1);
        }

        int litterCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int finalMask = (1 << litterCount) - 1;

       
        int[][][] maxEnergy = new int[n][m][1 << litterCount];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }

        Queue<State> queue = new LinkedList<>();

        queue.add(new State(sr, sc, energy, 0, 0));
        maxEnergy[sr][sc][0] = energy;

        int[] drow = {0, 1, 0, -1};
        int[] dcol = {-1, 0, 1, 0};

        while (!queue.isEmpty()) {

            State curr = queue.poll();

            int row = curr.row;
            int col = curr.col;
            int currEnergy = curr.energy;
            int mask = curr.mask;
            int moves = curr.moves;

            for (int i = 0; i < 4; i++) {

                int nr = row + drow[i];
                int nc = col + dcol[i];

            
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

             
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

            
                int newEnergy = currEnergy - 1;

                
                if (newEnergy < 0) {
                    continue;
                }

               
                int newMask = mask;

                if (classroom[nr].charAt(nc) == 'L') {
                    int index = litterIndex[nr][nc];
                    newMask = mask | (1 << index);
                }

             
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

              
                if (newMask == finalMask) {
                    return moves + 1;
                }

                
                if (newEnergy <= maxEnergy[nr][nc][newMask]) {
                    continue;
                }

                maxEnergy[nr][nc][newMask] = newEnergy;

                queue.add(
                    new State(
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    )
                );
            }
        }

        return -1;
    }
}