class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int num : nums){
            total += num;
        }
        int leftSum = 0;
        int rightSum;
        for(int i = 0; i < n; i++){
            leftSum += nums[i];
            rightSum = total - leftSum + nums[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
}