import java.util.*;
class triangle {
    public static void main(String[] args) {
        int[][] triangle = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for(int[] rows:dp){
        Arrays.fill(rows,-1);
        }
        int ans = func(triangle, 0, 0, n - 1, dp);
        System.out.println(ans);
    }

    public static int func(int[][] triangle, int i, int j, int n, int[][] dp) {
        if (i == n)
            return triangle[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = (i < n) ? triangle[i][j] + func(triangle, i + 1, j, n, dp) : 0;
        int right = (i < n) ? triangle[i][j] + func(triangle, i + 1, j + 1, n, dp) : 0;

        return dp[i][j] = Math.min(down, right);
    }
}