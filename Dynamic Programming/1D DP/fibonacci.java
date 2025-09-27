// import java.util.*;    // MEMOISATION
// class fibonacci {
//     public static void main(String[] args) {
//         int n = 6;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         int no = fibno(n - 1, dp);
//         System.out.println(no);
//     }

//     public static int fibno(int n, int[] dp) {
//         if (n <= 1)
//             return n;
//         if (dp[n] != -1)
//             return dp[n];
//         dp[n] = fibno(n - 1, dp) + fibno(n - 2, dp);
//         return dp[n];
//     }
// }

// import java.util.*; // TABULATION
// class fibonacci {
//     public static void main(String[] args) {
//         int n = 6;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 0);
//         dp[0] = 0;
//         dp[1] = 1;
//         for (int i = 2; i < n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         System.out.println(dp[n-1]);
//         for(int i=0; i<n;i++)
//         {
//             System.out.print(dp[i]+" ");
//         }
//     }
// }

// SPACE OPTIMISATION
class fibonacci {
    public static void main(String[] args) {
        int n = 6;
        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;
        for (int i = 2; i < n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(curr);
    }
}