
// class count_paths{
//     public static void main(String[] args)
//     {
//         int[][] arr= {{2,3,4,2},{2,4,3,1},{5,6,3,4}};
//         int n= arr.length-1;
//         int m= arr[0].length-1;
//         int ans= func(arr,n,m);
//         System.out.println(ans);
//     }

//     public static int func(int[][]arr,int i, int j)
//     {
//         if(j<0 || i<0) return 0;
//         if(i==0) return 1;

//         int up= func(arr,i-1,j);
//         int left = func(arr,i-1,j-1);

//         return up+left;
//     }
// }

// import java.util.*;
// class count_paths {
//     public static void main(String[] args) {
//         int[][] arr = { { 2, 3, 4, 2 }, { 2, 4, 3, 1 }, { 5, 6, 3, 4 } };
//         int n = arr.length - 1;
//         int m = arr[0].length - 1;
//         int[][] dp = new int[n + 1][m + 1];
//         for (int[] rows : dp) {
//             Arrays.fill(rows, -1);
//         }
//         int ans = func(arr, n, m, dp);
//         System.out.println(ans);
//     }

//     public static int func(int[][] arr, int i, int j, int[][] dp) {
//         if (j < 0 || i < 0)
//             return 0;
//         if (i == 0)
//             return 1;
//         if (dp[i][j] != -1)
//             return dp[i][j];
//         int up = func(arr, i - 1, j, dp);
//         int left = func(arr, i - 1, j - 1, dp);

//         return dp[i][j] = up + left;
//     }
// }

// import java.util.*;

// class count_paths {
//     public static void main(String[] args) {
//         int[][] arr = { { 2, 3, 4, 2 }, { 2, 4, 3, 1 }, { 5, 6, 3, 4 } };
//         int n = arr.length;
//         int m = arr[0].length;
//         int[][] dp = new int[n][m];
//         for (int[] rows : dp) {
//             Arrays.fill(rows, 0);
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {

//                 if (i == 0)
//                     dp[i][j] = 1;
//                 else {
//                     int up = dp[i - 1][j];
//                     int left = (j > 0) ? dp[i - 1][j - 1] : 0;
//                     dp[i][j] = left + up;
//                 }
//             }
//         }
//         System.out.println(dp[n - 1][m - 1]);

//     }
// }

class count_paths {
    public static void main(String[] args) {
        int[][] arr = { { 2, 3, 4, 2 }, { 2, 4, 3, 1 }, { 5, 6, 3, 4 } };
        int n = arr.length;
        int m = arr[0].length;
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0)
                    curr[j] = 1;
                else {
                    int up = prev[j];
                    int left = (j > 0) ? prev[j - 1] : 0;
                    curr[j] = left + up;
                }
            }
            prev = curr;
        }
        System.out.println(prev[m - 1]);

    }
}
