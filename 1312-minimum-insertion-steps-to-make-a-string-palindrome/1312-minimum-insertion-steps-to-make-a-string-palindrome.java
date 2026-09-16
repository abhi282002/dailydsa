class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        //dp[i][j] min insertion to make string palindrom s[i--j];

        //dp[0][0] = 0 dp[1][1] = 0 (1 len string always palindrom so 0 op need)

        for(int L = 2; L <= n; L++){
            for(int i = 0; i < n - L + 1 ; i++){
                 int j = L + i -1;
                 if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                 }else{
                     dp[i][j] = 1 + Math.min(dp[i + 1][j],dp[i][j - 1]);
                 }
            }
        }

        return dp[0][n - 1];
    }
}