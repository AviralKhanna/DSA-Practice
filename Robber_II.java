class Robber_II {
    public static void main(String[] args) {
     int[] arr = { 2, 1, 4, 9 };
        int n = arr.length;
        if(n==1) 
        System.out.println(arr[0]);
        int[] part1= new int[n-1];
        int[] part2= new int[n-1];
        for(int i=0;i<n-1;i++)
        {
            part1[i]=arr[i];
        }
        for(int i=1;i<n;i++)
        {
            part2[i-1]=arr[i];
        }
        // System.out.println(Arrays.toString(part1));
        // System.out.println(Arrays.toString(part2));
        int ans1= func(part1,part1.length);
        int ans2=func(part2,part2.length);
        System.out.println(Math.max(ans1,ans2));
    }

    public static int func(int[]arr, int n)
    {
        
        int prev = arr[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int not_take = 0 + prev;
            int take = arr[i];
            if (i > 1)
                take += prev2;
            int curr = Math.max(take, not_take);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}