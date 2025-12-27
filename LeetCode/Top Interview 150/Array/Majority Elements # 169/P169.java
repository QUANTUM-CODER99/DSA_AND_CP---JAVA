import java.util.Arrays;

class Solution {
    public static int majorityElement(int[] nums) {
        if (nums.length < 3)
            return nums[0];

        Arrays.sort(nums);
        int maxCount = Integer.MIN_VALUE, maxValue = nums[0], p = 0;
        for (int i = 1; i <= nums.length; i++)
            if ((i == nums.length || nums[p] != nums[i]) && maxCount < (i - p)) { // IMP CONDITION
                maxCount = i - p;
                maxValue = nums[p];
                p = i;
            }

        return maxValue;
    }
}
