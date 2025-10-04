
// min diff in partition of Subset
class Min_diff_partition {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 7 };
        int n = arr.length;
        int totsum = 0;
        for (int num : arr)
            totsum += num;
        int target = totsum / 2;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean take = false;
                boolean not_take = dp[i - 1][j];
                if (j >= arr[i])
                    take = dp[i - 1][j - arr[i]];
                dp[i][j] = (take || not_take) ? true : false;

            }
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totsum / 2; i++) {
            if (dp[n - 1][i] == true) {
                int s1 = i;
                int s2 = totsum - i;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }
        System.out.println(mini);
    }
}