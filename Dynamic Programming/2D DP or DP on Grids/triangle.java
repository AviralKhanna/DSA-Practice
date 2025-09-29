
class triangle {
    public static void main(String[] args) {
        int[][] triangle = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };
        int n = triangle.length;
        int ans = func(triangle, 0, 0, n - 1);
        System.out.println(ans);
    }

    public static int func(int[][] triangle, int i, int j, int n) {
        if (i == n)
            return triangle[i][j];

        int down = (i < n) ? triangle[i][j] + func(triangle, i + 1, j, n) : 0;
        int right = (i < n) ? triangle[i][j] + func(triangle, i + 1, j + 1, n) : 0;

        return Math.min(down, right);
    }
}