
// class Ninja{
//     public static void main(String[] args)
//     {
//         int [][] data= {{1,3,2},{3,4,5},{5,4,3},{93,42,93}};
//         int n= data.length;
//         int ans = function(data,n-1,3);
//         System.out.println(ans);
//     }

//     public static int function(int[][]data, int day, int activity)
//     {
//         if(day==0)
//         {
//         int maxi=Integer.MIN_VALUE;
//         for(int task=0; task<3;task++)
//         {
//             if(task!=activity)
//             maxi= Math.max(maxi,data[0][task]);
//         }
//         return maxi;
//     }
//     int maxi= Integer.MIN_VALUE;
//     for(int task=0; task<3;task++)
//     {
//         if(task!=activity)
//         {
//             int point = data[day][task] + function(data, day-1,task);
//             maxi = Math.max(point,maxi);
//         }
//     }
//     return maxi;
// }
// }

// import java.util.*;
// class Ninja {
//     public static void main(String[] args) {
//         int[][] data = { { 1, 3, 2 }, { 3, 4, 5 }, { 5, 4, 3 }, { 93, 42, 93 } };
//         int n = data.length;
//         int[][] dp = new int[n][4];
//         for (int[] rows : dp)
//             Arrays.fill(rows, -1);
//         int ans = function(data, n - 1, 3, dp);
//         System.out.println(ans);
//     }

//     public static int function(int[][] data, int day, int activity, int[][] dp) {
//         if (day == 0) {
//             int maxi = Integer.MIN_VALUE;
//             for (int task = 0; task < 3; task++) {
//                 if (task != activity)
//                     maxi = Math.max(maxi, data[0][task]);
//             }
//             return maxi;
//         }
//         if (dp[day][activity] != -1)
//             return dp[day][activity];
//         int maxi = Integer.MIN_VALUE;
//         for (int task = 0; task < 3; task++) {
//             if (task != activity) {
//                 int point = data[day][task] + function(data, day - 1, task, dp);
//                 maxi = Math.max(point, maxi);
//             }
//         }
//         return dp[day][activity] = maxi;
//     }
// }

class Ninja {               // TC O(4*3*N). SC = O(N) Space will be O(4) array space.
    public static void main(String[] args) {
        int[][] data = { { 1, 3, 2 }, { 3, 4, 5 }, { 5, 4, 3 }, { 93, 42, 93 } };
        int n = data.length;
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(data[0][1], data[0][2]);
        dp[0][1] = Math.max(data[0][0], data[0][2]);
        dp[0][2] = Math.max(data[0][1], data[0][0]);
        dp[0][3] = Math.max(data[0][1], Math.max(data[0][1], data[0][2]));

        for (int day = 1; day < n; day++) {
            for (int activity = 0; activity < 4; activity++) {
                for (int task = 0; task < 3; task++) {
                    if (task != activity) {
                        int point = data[day][task] + dp[day - 1][task];
                        dp[day][activity] = Math.max(dp[day][activity], point);
                    }
                }
            }
        }
        System.out.println(dp[n - 1][3]);
    }

}