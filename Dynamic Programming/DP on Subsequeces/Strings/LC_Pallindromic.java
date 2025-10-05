class LC_Pallindromic {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        int n = s.length();

        String rev = new StringBuilder(s).reverse().toString();

        // Call LCS-like recursive function
        int ans = func(s, n - 1, rev, n - 1);
        System.out.println("Length of Longest Palindromic Subsequence: " + ans);
    }

    public static int func(String s, int i, String rev, int j) {
        if (i < 0 || j < 0) return 0;

        if (s.charAt(i) == rev.charAt(j))
            return 1 + func(s, i - 1, rev, j - 1);
        else
            return Math.max(func(s, i, rev, j - 1), func(s, i - 1, rev, j));
    }
}
