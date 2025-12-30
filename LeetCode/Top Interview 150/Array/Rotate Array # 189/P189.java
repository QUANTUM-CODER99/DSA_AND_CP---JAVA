class Solution {
    public void rotate(int[] nums, int k) {
        int ret[] = new int[nums.length], index = k % nums.length;

        for (int i = 0; i < nums.length; i++)
            ret[(i + index) % nums.length] = nums[i];

        for (int i = 0; i < nums.length; i++)
            nums[i] = ret[i];
    }
}
