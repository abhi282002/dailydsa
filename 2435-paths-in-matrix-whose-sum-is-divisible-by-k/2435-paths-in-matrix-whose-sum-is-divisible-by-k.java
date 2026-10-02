class Solution {
    int M = 1000000000 + 7;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] t = new int[m + 1][n + 1][k + 1];

        for(int rem = 0; rem <= k - 1; rem++){
            t[m - 1][n - 1][rem] = ((rem + grid[m - 1][n - 1]) % k) == 0 ? 1 : 0;
        }

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                 if(i == m - 1 && j == n - 1) continue;
                for(int rem = 0; rem <= k - 1; rem++){
                   
                    int R = (rem + grid[i][j]) % k;

                    int down = 0;
                    int right = 0;

                    if (i + 1 < m) {
                        down = t[i + 1][j][R];
                    }

                    if (j + 1 < n) {
                        right = t[i][j + 1][R];
                    }

                    t[i][j][rem] = (down + right) % M;
                }
            }
        }
        
        return t[0][0][0];
    }
}