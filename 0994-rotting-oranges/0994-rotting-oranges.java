class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       Queue<Pair> q = new LinkedList<>();
       int freshCount = 0;
       int min = 0;
      int[] dRow = {-1, 0, 1, 0};
      int[] dCol = {0, 1, 0, -1};
       for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 2){
                q.offer(new Pair(i,j));
            }else if(grid[i][j] == 1){
               freshCount++;
            }
        }
       }
       if(freshCount == 0) return  0;
       while(!q.isEmpty()){
         int size = q.size();
         while(size-- > 0){
            Pair p = q.poll();
            int f_row = p.first;
            int s_col = p.second;
            for(int k = 0; k < 4; k++){
                int newRow = f_row + dRow[k];
                int newCol = s_col + dCol[k];
                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;
                    q.offer(new Pair(newRow,newCol));
                    freshCount--;
                }
            }
         }
         min++;
       }
       return freshCount == 0 ? (min - 1) : -1;
    }
}