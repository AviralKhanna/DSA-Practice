
//printing LCS

class print_LCS {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdqek";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        // System.out.println(dp[n][m]);

        for (int q = 0; q <= n; q++) {
            for (int w = 0; w <= m; w++) {
                // System.out.print(dp[q][w]);
            }
            // System.out.println();
        }
// PRINTING THE LCS
        int i = n;
        int j = m;
        String ans = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans = s1.charAt(i - 1)+ans;
                i--;
                j--;
            } else if (s1.charAt(i - 1) > s2.charAt(j - 1)) {
                i--;
            } else
                j--;
        }
        System.out.println(ans);
    }
}