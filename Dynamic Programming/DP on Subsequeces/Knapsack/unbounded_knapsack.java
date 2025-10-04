
class unbounded_knapsack{
    public static void main(String[] args)
    {
        int[]wt={2,4,6};
        int[] val={5,11,13};
        int capacity=10;
        int ans= func(wt,val,wt.length-1,capacity);
        System.out.println(ans);
    }

    public static int func(int[]wt, int[]val, int n, int capacity)
    {
        if(n==0) return (capacity / wt[0]) * val[0];
        if(capacity==0) return 0;
        if(wt[n]<=capacity)
        {
            //take or not take
            int take= val[n]+func(wt,val,n,capacity-wt[n]);
            int nottake= func(wt,val,n-1,capacity);
            return Math.max(take, nottake);
        }
        else 
        {return func(wt,val,n-1,capacity);}
    }
}