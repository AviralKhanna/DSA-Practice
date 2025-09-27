
// // min total energy for frog: input = [10,20,30,10]. Frog can jump 1 or 2 steps only.
// import java.util.*;

// class frog_jump {
//     public static void main(String[] args) {
//         int[] arr = { 10, 20, 30, 10 };
//         int n = arr.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         int ans = func(n - 1, arr, dp);
//         System.out.println(ans);
//     }

//     public static int func(int n, int[] arr, int[] dp) {
//         int mini = Integer.MAX_VALUE;
//         int jump_two = 0;
//         if (n == 0)
//             return 0;
//         if (n == 1)
//             return Math.abs(arr[1] - arr[0]);

//         if (dp[n] != -1)
//             return dp[n];
//         int jump_one = func(n - 1, arr, dp) + Math.abs(arr[n] - arr[n - 1]);
//         if (n > 1)
//             jump_two = func(n - 2, arr, dp) + Math.abs(arr[n] - arr[n - 2]);
//         mini = Math.min(mini, Math.min(jump_one, jump_two));
//         return dp[n] = mini;
//     }
// }

class frog_jump {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 10 };
        int n = arr.length;

        int prev2=0;
        int prev1= Math.abs(arr[1]-arr[0]);
        for(int i= 2; i<n; i++)
        {
            int jump_one = prev1 + Math.abs(arr[i] - arr[i - 1]);
            int jump_two = prev2 + Math.abs(arr[i] - arr[i - 2]);
            int curr = Math.min(jump_one, jump_two);
            prev2=prev1;
            prev1=curr;
        }
        System.out.println(prev1);
    }
}