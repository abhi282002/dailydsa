class Solution {
    public int reverseDegree(String s) {
         int n = s.length();
         int sum = 0;
         for(int i = 1; i <= n; i++){
             int num = 26 - (s.charAt(i - 1) - 'a');
             sum += num * i;
         }

         return sum;
    }
}