class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int longestJump = 0;
        int currentIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            longestJump = Math.max(longestJump, i + nums[i]);
            if (i == currentIndex) {
                jumps++;
                currentIndex = longestJump;
                if (currentIndex >= nums.length - 1)
                    break;
            }
        }

        return jumps;
    }
}
