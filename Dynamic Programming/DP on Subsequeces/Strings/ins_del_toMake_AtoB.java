
class ins_del_toMake_AtoB {
    public static void main(String[] args) {
        String A = "aviral";
        String S = "siddhi";

        int ans = A.length() + S.length() - 2 * func(A, S);
        System.out.println(ans);
    }

    public static int func(String a, String s) {
        int alen = a.length();
        int slen = s.length();
        int[] prev = new int[slen + 1];
        int[] curr = new int[slen + 1];
        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= slen; j++) {
                if (a.charAt(i - 1) == s.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone();
        }
        return curr[slen];
    }
}