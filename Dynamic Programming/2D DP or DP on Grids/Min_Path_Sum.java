
class Min_Path_Sum {
    public static void main(String[] args) {
        int[][] arr = { { 5, 9, 6 }, { 11, 5, 2 } };
        int n = arr.length;
        int m = arr[0].length;
        int ans = func(arr, n - 1, m - 1);
        System.out.println(ans);
    }

    public static int func(int[][] arr, int i, int j) {
        final int INF = 10000000;
        if (i == 0 && j == 0)
            return arr[0][0];
        if (i < 0 || j < 0)
            return INF;

        int up = func(arr, i - 1, j) + arr[i][j];
        int left = func(arr, i, j - 1) + arr[i][j];
        return Math.min(up, left);
    }
}