// import java.util.*;

// class subsetSum_K {
//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 2, 3 };
//         int n = arr.length;
//         int target = 3;
//         int[][] dp = new int[n][target + 1];
//         for (int[] rows : dp) {
//             Arrays.fill(rows, -1);
//         }
//         int ans = func(arr, n - 1, target, dp);
//         System.out.println(ans);
//     }

//     public static int func(int[] arr, int n, int target, int[][] dp) {
//         if (target == 0)
//             return 1;
//         if (n == 0) {
//             if (arr[n] == target)
//                 return 1;
//             else
//                 return 0;
//         }
//         if (dp[n][target] != -1)
//             return dp[n][target];
//         int take = 0;
//         int not_take = func(arr, n - 1, target, dp);
//         if (arr[n] <= target)
//             take = func(arr, n - 1, target - arr[n], dp);
//         return dp[n][target] = take + not_take;
//     }
// }

class count_subsetSum_K {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int n = arr.length;
        int target = 3;
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= target)
            dp[0][arr[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                int take = 0;
                int not_take = dp[i - 1][j];
                if (arr[i] <= j)
                    take = dp[i - 1][j - arr[i]];
                dp[i][j] = take + not_take;
            }
        }
        System.out.println(dp[n - 1][target]);
    }

}