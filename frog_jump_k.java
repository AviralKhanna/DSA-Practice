// class frog_jump_k
// {
// public static void main(String[] args)
// {
//     int[] arr= {10,20,30,10,10};
//     int k=3;
//     int ans = func(arr,arr.length-1,k);
//     System.out.println(ans);

// }

// public static int func(int[]arr, int n, int k)
// {
//     if(n==0) return 0;
//     int take=0;
//     int mini= Integer.MAX_VALUE;
//     for(int i=1;i<=k;i++)
//     {
//         if(n-i>=0)
//         take = func(arr,n-i,k) + Math.abs(arr[n]-arr[n-i]);
//         mini= Math.min(mini,take);
//     }
//     return mini;
// }
// }
import java.util.*;
class frog_jump_k
{
public static void main(String[] args)
{
    int[] arr= {10, 20, 30, 40, 50};
    int n= arr.length;
    int k=2;
    int[] dp= new int[n];
    Arrays.fill(dp,0);
    dp[0]=0;
    int take=0;
    for(int i=1; i<n;i++)
    { int mini= Integer.MAX_VALUE;
        for(int j=1; j<=k;j++)
        {
            if(i-j>=0)
            take = dp[i-j] + Math.abs(arr[i]-arr[i-j]);
            mini= Math.min(mini,take);
        }
        dp[i]=mini;
    }
    System.out.println(dp[n-1]);
}
}
// public static int func(int[]arr, int n, int k, int[]dp)
// {
//     if(n==0) return 0;
//     int take=0;
//     int mini= Integer.MAX_VALUE;
//     if(dp[n]!=-1) return dp[n];
//     for(int i=1;i<=k;i++)
//     {
//         if(n-i>=0)
//         take = func(arr,n-i,k,dp) + Math.abs(arr[n]-arr[n-i]);
//         mini= Math.min(mini,take);
//     }
//     dp[n]=mini;
//     return dp[n];
    
// }
// }