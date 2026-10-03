class Pair{
    int dist;
    int x;
    int y;
    Pair(int dist,int x,int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int m;
    int n;
    int[] row = {1, 0, -1, 0};
    int[] col = {0, 1, 0, -1};
    boolean isSafe(int x,int y){
        return x >=0 && x < m && y >= 0 && y < n;
    }
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));

        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(result[i],Integer.MAX_VALUE);
        }

        result[0][0] = 0;
        pq.offer(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair pr = pq.poll();
            int diff = pr.dist;
            int x = pr.x;
            int y = pr.y;
            for(int i = 0; i < 4; i++){
                int new_x = x + row[i];
                int new_y = y + col[i];
                if(!isSafe(new_x,new_y)) continue;
                int absDiff = Math.abs(heights[x][y] - heights[new_x][new_y]);
                int maxDiff = Math.max(diff,absDiff); //why max because we need to keep maxDiff in the current path so if current abs diff is less then prev in ongoing path then we will not considered the current difference go with previous only
                if(result[new_x][new_y] > maxDiff){
                    result[new_x][new_y] = maxDiff;
                    pq.offer(new Pair(maxDiff,new_x,new_y));
                }
            }
        }

        return result[m - 1][n - 1];
    }
}