class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int output[] = new int[nums.length];
        int left = 1, right = 1;

        for (int i = nums.length-1; i > -1; i--) {
            int r = nums[i];
            output[i] = right; 
            right *= r;
        }

        for(int i=0;i<nums.length;i++) {
            int l = nums[i];
            nums[i] = left;
            left *= l;
        }

        for (int i = 0; i < nums.length; i++)
            output[i] = nums[i] * output[i];

        return output;
    }
}
