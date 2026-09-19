class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0;
        int cnt1 = 0;
        int cand2 = 0;
        int cnt2 = 0;
        for(int i = 0; i < nums.length; i++){
   if (nums[i] == cand1)
    cnt1++;
else if (nums[i] == cand2)
    cnt2++;
else if (cnt1 == 0) {
    cand1 = nums[i];
    cnt1 = 1;
}
else if (cnt2 == 0) {
    cand2 = nums[i];
    cnt2 = 1;
}
else {
    cnt1--;
    cnt2--;
}
        }

        cnt1 = 0;
        cnt2 = 0;

        for(int num : nums){
            if(num == cand1){
                cnt1++;
            }else if(num == cand2){
                cnt2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        if(cnt1 > nums.length / 3){
            result.add(cand1);
        }

        
        if(cnt2 > nums.length / 3){
            result.add(cand2);
        }

        return result;
    }
}