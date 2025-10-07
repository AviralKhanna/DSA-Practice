
class edit_distance
{
    public static void main(String[] args)
    {
        String s1= "horse";
        String s2= "ose";

        int ans = func(s1,s2,s1.length(),s2.length());
        System.out.println(ans);
    }

    public static int func(String s1, String s2, int i, int j)
    {
        // Base conditions
        if(j==0) return i;
        if(i==0) return j;

        // logic
        if(s1.charAt(i-1)==s2.charAt(j-1))
        return func(s1,s2,i-1,j-1);

        else return 1+ Math.min(func(s1,s2,i-1,j), Math.min(func(s1,s2,i-1,j-1),func(s1,s2,i,j-1)));
    }
}