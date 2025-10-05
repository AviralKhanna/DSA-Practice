
// longest common subsequencd

import java.util.Arrays;

class LCS {
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        int s1_len = s1.length();
        int s2_len = s2.length();
        int[][] dp = new int[s1_len][s2_len];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        int ans = func(s1, s2, s1_len - 1, s2_len - 1, dp);
        System.out.println(ans);
    }

    public static int func(String s1, String s2, int s1_len, int s2_len, int[][] dp) {
        if (s1_len < 0 || s2_len < 0)
            return 0;
        if (dp[s1_len][s2_len] != -1)
            return dp[s1_len][s2_len];
        // take
        if (s1.charAt(s1_len) == s2.charAt(s2_len)) {
            return 1 + func(s1, s2, s1_len - 1, s2_len - 1, dp);
        }
        // not take
        return dp[s1_len][s2_len] = Math.max(func(s1, s2, s1_len - 1, s2_len, dp),
                                             func(s1, s2, s1_len, s2_len - 1, dp));
    }
}