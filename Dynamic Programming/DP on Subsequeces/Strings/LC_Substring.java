
class LC_Substring {
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, curr[j]);
                } else
                    curr[j] = 0;
            }
            prev = curr.clone();
        }
        System.out.println(ans);
    }
}