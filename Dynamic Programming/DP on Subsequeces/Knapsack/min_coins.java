import java.util.Arrays;

class min_coins {
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
                return target / coins[0];
            else
                return 10000000;
        }
        if (dp[n][target] != -1)
            return dp[n][target];
        int take = 10000000;
        if (coins[n] <= target)
            take = 1 + func(coins, target - coins[n], n, dp);
        int nottake = func(coins, target, n - 1, dp);
        return dp[n][target] = Math.min(take, nottake);
    }
}