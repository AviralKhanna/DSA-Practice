// import java.util.*;
// class distinct_subsequence
// {
//     public static void main(String[] args)
//     {
//         String s1= "babgbag";
//         String s2="bag";
//         int n=s1.length();
//         int m=s2.length();
//         int[][]dp= new int[n+1][m+1];
//         for(int[]rows:dp)
//         {
//             Arrays.fill(rows,-1);
//         }
//         int ans= func(s1,s2,n, m,dp);
//         System.out.println(ans);
//     }

//     public static int func(String s1, String s2, int i, int j, int[][]dp)
//     {
//         if(j==0) return 1; 
//         if(i==0) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(s1.charAt(i-1)== s2.charAt(j-1))
//         return dp[i][j]= func(s1,s2,i-1,j-1,dp)+ func(s1,s2,i-1,j,dp);
//         else 
//         return dp[i][j]= func(s1,s2,i-1,j,dp);
//     }
// }

// class distinct_subsequence {
//     public static void main(String[] args) {
//         String s1 = "babgbag";
//         String s2 = "bag";
//         int n = s1.length();
//         int m = s2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = 1;
//         }
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (s1.charAt(i - 1) == s2.charAt(j - 1))
//                     dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                 else
//                     dp[i][j] = dp[i - 1][j];
//             }
//         }
//         System.out.println(dp[n][m]);
//     }
// }
// import java.util.*;
// class distinct_subsequence
// {
//     public static void main(String[] args)
//     {
//         String s1= "babgbag";
//         String s2="bag";
//         int n=s1.length();
//         int m=s2.length();
//         int[][]dp= new int[n+1][m+1];
//         for(int[]rows:dp)
//         {
//             Arrays.fill(rows,-1);
//         }
//         int ans= func(s1,s2,n, m,dp);
//         System.out.println(ans);
//     }

//     public static int func(String s1, String s2, int i, int j, int[][]dp)
//     {
//         if(j==0) return 1; 
//         if(i==0) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(s1.charAt(i-1)== s2.charAt(j-1))
//         return dp[i][j]= func(s1,s2,i-1,j-1,dp)+ func(s1,s2,i-1,j,dp);
//         else 
//         return dp[i][j]= func(s1,s2,i-1,j,dp);
//     }
// }


// 1-D Optimised
class distinct_subsequence {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
            prev[0] = 1;
        for (int i = 1; i <= n; i++) { 
            for (int j = m; j >=1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    prev[j] = prev[j - 1] + prev[j];
            }
        }
        System.out.println(prev[m]);
    }
}