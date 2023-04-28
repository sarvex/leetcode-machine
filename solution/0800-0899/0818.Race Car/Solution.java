class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; ++i) {
            int k = 32 - Integer.numberOfLeadingZeros(i);
            if (i == (1 << k) - 1) {
                dp[i] = k;
                continue;
            }
            dp[i] = dp[(1 << k) - 1 - i] + k + 1;
            for (int j = 0; j < k; ++j) {
                dp[i] = Math.min(dp[i], dp[i - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
            }
        }
        return dp[target];
    }
}