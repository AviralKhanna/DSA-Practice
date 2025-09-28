
// import java.util.*;
// class count_paths_obstacles{
//     public static void main(String[] args)
//     {
//         int[][] arr= {{0,0,0,0},{-1,0,0,-1},{0,-1,-1,0}};
//         int n= arr.length;
//         int m = arr[0].length;
//         int[][]dp= new int[n][m];
//         for(int[]rows:dp)
//         {
//             Arrays.fill(rows,-1);
//         }
//         int ans = func(arr,n-1,m-1,dp);
//         System.out.println(ans);
//     }

//     public static int func(int[][]arr, int i, int j,int[][]dp)
//     {
//         if(i<0 || j<0) return 0;
//         if(arr[i][j]==-1) return 0;
//         if(i==0 && j==0) return 1;
//         if(dp[i][j]!=-1) return dp[i][j];
//         int up = func(arr, i-1, j,dp);
//         int left = func(arr, i-1, j-1,dp);
//         return dp[i][j]= up+left;
//     }
// }

import java.util.*;

class count_paths_obstacles {
    public static void main(String[] args) {
        int[][] arr = { { 0, 0, 0, 0 }, { -1, 0, 0, -1 }, { 0, -1, -1, 0 } };
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int[] rows : dp) {
            Arrays.fill(rows, 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j==0)
                    dp[i][j] = 1;
                else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);

    }
}