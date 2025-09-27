// import java.util.*;

// class adjElement {
//     public static void main(String[] args) {
//         int[] arr = { 2, 1, 4, 9 };
//         int n = arr.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         int ans = func(arr, n - 1, dp);
//         System.out.println(ans);
//     }

//     public static int func(int[] arr, int n, int[] dp) {
//         if (n == 0)
//             return arr[0];
//         if (n < 0)
//             return 0;
//         if (dp[n] != -1)
//             return dp[n];
//         int take = arr[n] + func(arr, n - 2, dp);
//         int not_take = 0 + func(arr, n - 1, dp);
//         return dp[n] = Math.max(take, not_take);
//     }
// }

class adjElement {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        int n = arr.length;
        int prev = arr[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int not_take = 0 + prev;
            int take = arr[i];
            if (i > 1)
                take += prev2;
            int curr = Math.max(take, not_take);
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);
    }
}

// public static int func(int[] arr, int n, int[] dp) {
// if (n == 0)
// return arr[0];
// if (n < 0)
// return 0;
// if (dp[n] != -1)
// return dp[n];
// int take = arr[n] + func(arr, n - 2, dp);
// int not_take = 0 + func(arr, n - 1, dp);
// return dp[n] = Math.max(take, not_take);
// }
// }