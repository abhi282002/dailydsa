class Solution {
    int n;
    boolean[][] isPalin;
    int[][] dp;
    int solve(String s,int k, int i,int j){
        if(i >= n || j >= n) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(isPalin[i][j]){
           int take = 1 + solve(s, k, j + 1, j + k);

           int expand = solve(s, k, i, j + 1);

           
           int slide = solve(s, k, i + 1, j + 1);
           
           return dp[i][j] =  Math.max(take,Math.max(expand,slide));
        }
        int expand = solve(s, k, i, j + 1);
        int slide = solve(s, k, i + 1, j + 1);
        return dp[i][j] =  Math.max(expand,slide);
    }
    public int maxPalindromes(String s, int k) {
        n = s.length();
        isPalin = new boolean[n + 1][n + 1];

        dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], - 1);
        }

        for(int L = 1; L <= n; L++){
            for(int i = 0; i + L <= n; i++){
                 int j = L + i - 1;
                 if(i == j){
                    isPalin[i][j] = true;
                 }else if(i + 1 == j){
                     isPalin[i][j] = (s.charAt(i) == s.charAt(j));
                 }else{
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j)) && isPalin[i + 1][j - 1];
                 }
            }
        }

        return solve(s, k, 0, k - 1);
    }
}