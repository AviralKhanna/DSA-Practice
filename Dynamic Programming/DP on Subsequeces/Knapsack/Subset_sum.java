// import java.util.Arrays;

// class Subset_sum {
//     public static void main(String[] args) {
//         int[] arr = { 2, 3, 8, 10, 7 };
//         int target = 11;
//         int[][] dp = new int[arr.length][target + 1];
//         for (int[] rows : dp) {
//             Arrays.fill(rows, -1);
//         }
//         boolean ans = func(arr, target, arr.length - 1, dp);
//         if (ans)
//             System.out.println("TRUE");
//         else
//             System.out.println("FALSE");
//     }

//     public static boolean func(int[] arr, int target, int n, int[][] dp) {
//         // base conditions
//         if (target == 0)
//             return true;
//         if (n == 0) {
//             return (arr[0] == target);
//         }
//         if (dp[n][target] != -1)
//             return dp[n][target] == 1;
//         boolean take = false;
//         boolean not_take = func(arr, target, n - 1, dp);
//         if (target >= arr[n])
//             take = func(arr, target - arr[n], n - 1, dp);

//         dp[n][target] = (take || not_take) ? 1 : 0;
//         return dp[n][target] == 1;

//     }
// }

// class Subset_sum {
//     public static void main(String[] args) {
//         int[] arr = { 2, 3, 8, 10, 7 };
//         int target = 11;
//         int n = arr.length;
//         boolean[][] dp = new boolean[n][target + 1];

//         for (int i = 0; i < n; i++) {
//             dp[i][0] = true;
//         }
//         dp[0][arr[0]] = true;

//         for (int i = 1; i < n; i++) {
//             for (int j = 1; j <= target; j++) {
//                 boolean take = false;
//                 boolean not_take = dp[i - 1][j];
//                 if (j >= arr[i])
//                     take = dp[i - 1][j - arr[i]];

//                 dp[i][j] = (take || not_take);
//             }
//         }
//         System.out.println(dp[n - 1][target]);
//     }
// }


class Subset_sum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 8, 10, 7 };
        int target = 11;
        int n = arr.length;
        boolean[]prev= new boolean[target+1];
        boolean[]curr= new boolean[target+1];
        curr[0]=prev[0]=true;
        if(target>=arr[0]) 
        curr[arr[0]]=true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean take = false;
                boolean not_take = prev[j];
                if (j >= arr[i])
                    take = prev[j - arr[i]];

                curr[j] = (take || not_take);
            }
            prev=curr.clone();
        }
        System.out.println(prev[target]);
    }
}

// MORE OPTIMISED WITH 1D ARRAY ONLY
// boolean[] dp = new boolean[target + 1];
//         dp[0] = true;

//         if (arr[0] <= target) dp[arr[0]] = true;

//         for (int i = 1; i < n; i++) {
//             for (int j = target; j >= arr[i]; j--) {    reverse loop
//                 dp[j] = dp[j] || dp[j - arr[i]];
//             }
//         }

//         System.out.println(dp[target]); // true