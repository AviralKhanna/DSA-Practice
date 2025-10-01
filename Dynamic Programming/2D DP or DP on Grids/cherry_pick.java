// fixed starting and variable ending points

public class cherry_pick {
    public static void main(String[] args) {
        int[][] arr = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 2, 5 } };
        int m = arr[0].length;
        int[][][] dp = new int[arr.length][m][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = func(arr, 0, 0, m - 1, dp);
        System.out.println(ans);
    }

    public static int func(int[][] arr, int i, int j1, int j2, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= arr[0].length || j2 >= arr[0].length)
            return -10000000;
        if (i == arr.length - 1) {
            if (j1 == j2)
                return arr[i][j1];
            else
                return arr[i][j1] + arr[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int max = -10000000;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int value = 0;
                if (j1 == j2)
                    value = arr[i][j1] + func(arr, i + 1, j1 + d1, j2 + d2, dp);
                else
                    value = arr[i][j1] + arr[i][j2] + func(arr, i + 1, j1 + d1, j2 + d2, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }
}
