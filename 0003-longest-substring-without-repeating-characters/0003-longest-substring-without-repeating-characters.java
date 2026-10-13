class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[255];
        Arrays.fill(hash, - 1);
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < n){ 
          int val = s.charAt(right);
          if(hash[val] != -1){
             if(left <= hash[val]){
                left = hash[val] + 1;
             }
          }
          if(left <= right){
            maxLen = Math.max(maxLen,right - left + 1);
          }
          hash[val] = right;
          right++;
        }
        return maxLen;
    }
}