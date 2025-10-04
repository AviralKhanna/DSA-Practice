import java.util.Arrays;

class Coin2 {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int target = 7;
        int[][] dp = new int[coins.length][target + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        int ans = func(coins, target, coins.length - 1, dp);
        System.out.println(ans);
    }

    public static int func(int[] coins, int target, int n, int[][] dp) {
        if (n == 0) {
            if (target % coins[0] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[n][target] != -1)
            return dp[n][target];
        int take = 0;
        if (coins[n] <= target)
            take = func(coins, target - coins[n], n, dp);
        int nottake = func(coins, target, n - 1, dp);
        return dp[n][target] = take+nottake;
    }
}