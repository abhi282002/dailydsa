class Solution {
    int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = sum;
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(sum + nums[i],nums[i]);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    int minSubArray(int[] nums) {
        int sum = nums[0];
        int minSum = sum;
        for(int i = 1; i < nums.length; i++){
            sum = Math.min(sum + nums[i],nums[i]);
            minSum = Math.min(minSum,sum);
        }
        return minSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n =  nums.length;
        int totalSum = nums[0];
        for(int i = 1; i < n; i++){
            totalSum += nums[i];
        }
        int maxSum = maxSubArray(nums);
        int minSum = minSubArray(nums);

        int circularSum = totalSum - minSum;

        if(maxSum > 0){
            return Math.max(circularSum,maxSum);
        }
        return maxSum;
    }
}