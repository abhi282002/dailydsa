class Solution {
    int countOverlap(int[][] img1, int[][] img2,int row,int col){
        int n = img1.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int nr = row + i;
                int nc = col + j;
                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                
                if(img1[i][j] == 1 && img2[nr][nc] == 1){
                    count++;
                }

            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int result = 0;
        for(int row = -n + 1; row < n; row++){
            for(int col = -n + 1; col < n; col++){
                int count = countOverlap(img1,img2,row,col);
                result = Math.max(result,count);
            }
        }
        return result;
    }
}