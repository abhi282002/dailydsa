class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int m;
    int n;
    boolean isSafe(int x,int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }

        // Already at destination
        if (m == 1 && n == 1) {
            return 1;
        }
        q.offer(new Pair(0,0));
        grid[0][0] = 1;
        int[] row = {1, 0, -1, 0, -1, 1, 1, -1};
        int[] col = {0, -1, 0 ,1, -1, 1, -1, 1};
        int level = 1;
        while(!q.isEmpty()){
            int N = q.size();
            while(N-- > 0){
                Pair cord = q.poll();
                int x = cord.x;
                int y = cord.y;
                for(int i = 0; i  < 8; i++){
                    int new_x = row[i] + x;
                    int new_y = col[i] + y;
                    if(isSafe(new_x,new_y) && grid[new_x][new_y] == 0){
                         if(new_x == m - 1 && new_y == n - 1){
                            return level + 1;
                         }
                         q.offer(new Pair(new_x,new_y));
                         grid[new_x][new_y] = 1;
                    }
                }
            }
            level++;
        }

        return -1;
    }
}