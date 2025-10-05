class insertions_forLCS_Pallin {      // FORMULA --> str.length()-lcs
    public static void main(String[] args) {
        String s = "aviral";
        int ans = ansfunc(s);
        System.out.println(s.length() - ans);
    }

    public static int ansfunc(String s) {

        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[] curr = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1))
                    curr[j] = 1 + prev[j];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone();
        }
        // System.out.println(prev[n]); ara
        return prev[n];
    }
}