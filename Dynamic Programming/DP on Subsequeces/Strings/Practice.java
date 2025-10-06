public class Practice {
    public static void main(String[] args) {
        String s1= "aviral";
        String s2="Khanna";

        int s1len= s1.length();
        int s2len= s2.length();

        int ans= func(s1,s2,s1len-1,s2len-1);
        System.out.println(ans);
    }

    public static int func(String s1, String s2, int n, int m)
    {
        if(n<0 || m<0) return 0;

        if(s1.charAt(n)==s2.charAt(m))
        return 1+func(s1, s2, n-1, m-1);

        else return Math.max(func(s1, s2, n-1, m),func(s1, s2, n, m-1));

    }
}
