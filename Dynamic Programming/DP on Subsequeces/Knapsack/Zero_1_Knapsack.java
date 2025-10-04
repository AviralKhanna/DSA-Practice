// import java.util.Arrays;

// public class Zero_1_Knapsack {
//     public static void main(String[] args) {
//         int[] wt = { 2, 3, 4, 5 };
//         int cap = 7;
//         int[] val = { 16, 19, 23, 28 };
//         int n = wt.length;
//         int[][] dp = new int[cap + 1][n + 1];
//         for (int[] rows : dp) {
//             Arrays.fill(rows, -1);
//         }
//         int ans = func(wt, cap, val, n, dp);
//         System.out.println(ans);
//     }

//     public static int func(int[] wt, int cap, int[] val, int n, int[][] dp) {
//         if (n == 0 || cap == 0)
//             return 0;
//         if (dp[cap][n] != -1)
//             return dp[cap][n];
//         if (wt[n - 1] > cap)
//             return dp[cap][n] = func(wt, cap, val, n - 1, dp);
//         else if (wt[n - 1] <= cap) {
//             // take and not take for valid capacity wt.
//             int take = val[n - 1] + func(wt, cap - wt[n - 1], val, n - 1, dp);
//             int nottake = func(wt, cap, val, n - 1, dp);
//             return dp[cap][n] = Math.max(take, nottake);
//         }
//         return 0;
//     }
// }
public class Zero_1_Knapsack {
    public static void main(String[] args) {
        int[] wt = { 2, 3, 4, 5 };
        int cap = 7;
        int[] val = { 16, 19, 23, 28 };
        int n = wt.length;
        int[][] dp = new int[cap + 1][n + 1];

        for (int i = 0; i <= cap; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= cap; i++) {
            for (int j = 1; j <= n; j++) {
                if (wt[j - 1] > i)
                    dp[i][j] = dp[i][j - 1];
                else if (wt[j - 1] <= i) {
                    // take and not take for valid capacity wt.
                    int take = val[j - 1] + dp[i - wt[j - 1]][j - 1];
                    int nottake = dp[i][j - 1];
                    dp[i][j] = Math.max(take, nottake);
                }
            }

        }
        System.out.println(dp[cap][n]);

    }
}