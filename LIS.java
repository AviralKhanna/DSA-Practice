import java.util.Arrays;

class LIS { // Longest Increasing Subsequence
    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 5, 6, 33, 22, 453 };
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];

        // TC=O(N2) and SC=O(N) solution. Trace back the LIS
        Arrays.fill(dp, 1);
        for(int i=0; i<hash.length;i++)
        {
            hash[i]=i+1;
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i] && 1+dp[j]>dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i]=j;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);





        // for (int[] rows : dp) {
        // Arrays.fill(rows, -1);
        // }
        // System.out.println(func(arr, n, 0, -1, dp));
        // for(int i=0; i<n; i++)
        // {
        // for(int j=0; j<=n; j++)
        // {
        // System.out.print(dp[i][j] +" ");
        // }
        // System.out.println();
        // }
    }

    // public static int func(int[] arr, int n, int ind, int prev_ind, int[][] dp)

    // {
    // if (ind == n)
    // return 0;
    // if (dp[ind][prev_ind + 1] != -1)
    // return dp[ind][prev_ind + 1];
    // // not take
    // int len = 0 + func(arr, n, ind + 1, prev_ind, dp);

    // if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
    // len = Math.max(len, 1 + func(arr, n, ind + 1, ind, dp));
    // }
    // dp[ind][prev_ind + 1] = len;
    // return dp[ind][prev_ind + 1];
    // }
}