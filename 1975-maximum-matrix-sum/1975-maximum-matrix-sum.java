class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long totalSum = 0;
        int negEle = 0;
        long minAbsEle = Long.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                totalSum += ((long) Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0){
                    negEle++;
                }
                minAbsEle = Math.min(minAbsEle,Math.abs(matrix[i][j]));
            }
        }
        if(negEle % 2 == 0) return totalSum;

        return totalSum - 2 * minAbsEle;
    }
}