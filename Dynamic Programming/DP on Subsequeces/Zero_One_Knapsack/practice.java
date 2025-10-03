import java.util.Arrays;

class practice {
    public static void main(String[] args) {
        int[] arr = { 1, 6, 11, 5 };
        int target = 0;
        int total_sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            total_sum += arr[i];
        }
        target = total_sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        int mini = Integer.MAX_VALUE;
        func(arr, n - 1, dp, target);
        for (int i = 0; i <= target; i++) {
            if (dp[n - 1][i] == 1) {
                int s1 = i;
                int s2 = total_sum - i;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }
        System.out.println(mini);
    }
    public static int func(int[] arr, int n, int[][] dp, int target) {
        if (target == 0)
            return 1;
        if (n == 0) {
            if (arr[0] == target)
                return 1;
            else
                return 0;
        }
        if (dp[n][target] != -1)
            return dp[n][target];
        int take = 0;
        int not_take = func(arr, n - 1, dp, target);
        if (arr[n] <= target)
            take = func(arr, n - 1, dp, target - arr[n]);

        return dp[n][target] = (take == 1 || not_take == 1) ? 1 : 0;

    }
}