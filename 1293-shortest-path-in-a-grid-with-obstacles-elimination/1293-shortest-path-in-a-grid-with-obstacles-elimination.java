class Pair{
    int i;
    int j;
    int k;
    Pair(int i,int j, int k){
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,k));
        boolean[][][] visited = new boolean[m + 1][n + 1][k + 1];
        visited[0][0][k] = true;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int step = 0;
        while(!q.isEmpty()){
            int s = q.size();
            while(s-- > 0){
                Pair ele = q.poll();
                int row = ele.i;
                int col = ele.j;
                if(row == m - 1 && col == n - 1) return step;
                int obs = ele.k;
                for(int i = 0; i < 4; i++){
                    int nr = row + dr[i];
                    int nc = col + dc[i];           
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if(grid[nr][nc] == 0 && !visited[nr][nc][obs]){
                        q.offer(new Pair(nr,nc,obs));
                        visited[nr][nc][obs] = true;
                    }else if(grid[nr][nc] == 1 && obs > 0 && !visited[nr][nc][obs - 1]){
                         q.offer(new Pair(nr,nc,obs - 1));
                         visited[nr][nc][obs - 1] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}