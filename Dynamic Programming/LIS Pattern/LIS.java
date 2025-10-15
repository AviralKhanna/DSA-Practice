import java.util.ArrayList;
import java.util.Arrays;

class LIS { // Longest Increasing Subsequence
    public static void main(String[] args) {
        int[] arr = { 5,4,11,1,16,8};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // TC=O(N2) and SC=O(N) solution. Trace back the LIS
        // int maxi = 1;
        // for (int i = 0; i < n; i++) {
        //     for (int prev = 0; prev < i; prev++) {
        //         if (arr[prev] < arr[i]) {
        //             dp[i] = Math.max(dp[i], 1 + dp[prev]);
        //         }
        //         maxi = Math.max(maxi, dp[i]);
        //     }
        // }
        // System.out.println(maxi);

        // PRINTING LIS
        // take a hash array = [0,1,2,3,4,5.....n] and whenever the dp array is updated, 1+dp[prev] make this hash array[i] as prev i.e index. 

        int[] hash= new int[n];
        for(int i=0; i<n; i++)
        {
            hash[i]=i;
        }
        int maxi = 1;
        int last_index=0;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && 1 + dp[prev]>dp[i]) {
                    dp[i] = 1+dp[prev];
                    hash[i]=prev;
                }
            }
                if(dp[i]>maxi)
                {
                    maxi= dp[i];
                    last_index=i;
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(arr[last_index]);
            while(hash[last_index]!=last_index)
            {
                last_index=hash[last_index];
                ans.add(arr[last_index]);
            }
            System.out.println(ans.reversed());
        }
    }

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
//}