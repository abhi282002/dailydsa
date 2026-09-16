class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int ele : nums){
            if(i == 0 || i == 1 || ele != nums[i - 2]){
                nums[i] = ele;
                i += 1;
            }
        }

        return i;
    }
}