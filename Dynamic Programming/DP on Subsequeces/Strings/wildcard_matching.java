
class wildcard_matching{
    public static void main(String[] args)
    {
        String s1= "*patt&rn";
        String s2= "samepattern";

        boolean ans= func(s1,s2,s1.length(),s2.length());
        System.out.println(ans);
    }

    public static boolean func(String s1, String s2, int i, int j)
    {
        if(i==0 && j==0) return true;
        if(i==0 && j>0) return false;
        if(i>0 && j==0){
            for(int ii=1; ii<=i; ii++)
            {
                if(s1.charAt(ii-1)!='*')
                return false;
            }
            return true;
        }

        if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='&')
        return func(s1,s2,i-1,j-1);

        else if(s1.charAt(i-1)=='*')
        return func(s1,s2,i-1,j)|| func(s1,s2,i,j-1);

        else return false;
    }
}