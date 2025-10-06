
// shortest common supersequence

class shortest_supersequence {
    public static void main(String[] args) {
        String a = "brute";
        String b = "groot";
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int ans = func1(a, b, dp);
        // String ans2 = func2(a, b, dp);
        String ans2 = func2(a, b, dp);
        System.out.println(a.length() + b.length() - ans);
        System.out.println(ans2);
    }

    public static int func1(String a, String b, int[][] dp) {
        int alen = a.length();
        int blen = b.length();
        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[alen][blen];
    }

    public static String func2(String a, String b, int[][] dp) {
        // for (int i = 0; i <= a.length(); i++) {
        // for (int j = 0; j <= b.length(); j++) {
        // System.out.print(dp[i][j]);
        // }
        // System.out.println();
        // }
        String ans = "";
        int i = a.length();
        int j = b.length();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans = a.charAt(i - 1) + ans;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) // UP
            {
                ans = a.charAt(i - 1) + ans;
                i--;
            } else { // left
                ans = b.charAt(j - 1) + ans;
                j--;
            }
        }
        while (i > 0) {
            ans = a.charAt(i - 1) + ans;
            i--;
        }
        while (j > 0) {
            ans = b.charAt(j - 1) + ans;
            j--;
        }
        return ans;
    }
}