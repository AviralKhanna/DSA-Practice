
// variable start and variable end pattern
class falling_path {
    public static void main(String[] args) {
        int[][] data = { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };
        int n = data.length;
        int m = data[0].length;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, func(data, n - 1, j));
        }

        System.out.println(max);
    }

    public static int func(int[][] data, int i, int j) {
        if (j < 0 || j >= data[0].length)
            return Integer.MIN_VALUE;
        if (i == 0)
            return data[i][j];

        int up = func(data, i - 1, j) + data[i][j];
        int rd = func(data, i - 1, j + 1) + data[i][j];
        int ld = func(data, i - 1, j - 1) + data[i][j];

        return Math.max(up, Math.max(rd, ld));
    }
}