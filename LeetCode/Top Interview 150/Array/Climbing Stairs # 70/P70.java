// IMPROVES THE TIME COMPLEXITY TO LINEAR COMPLEXITY - O(n)

class Solution {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        return rec(0, n);
    }

    private int rec(int level, int n) {
        if (level == n) return 1;
        if (dp[level] != 0) return dp[level];

        int ways = 0;
        for (int j = 1; j <= 2; j++) {
            if (level + j <= n)
                ways += rec(level + j, n);
        }

        dp[level] = ways;
        return ways;
    }
}
