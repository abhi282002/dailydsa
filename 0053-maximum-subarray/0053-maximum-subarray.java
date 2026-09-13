class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = sum;
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(sum + nums[i],nums[i]);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}