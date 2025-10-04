
class rod_cutting {
    public static void main(String[] args) {
        int[] price = { 2, 5, 7, 8, 10 };
        int n = price.length;
        int target = 5;

        int ans = func(price, n - 1, target);
        System.out.println(ans);
    }

    public static int func(int[] price, int n, int target) {
        if (n == 0) {
            return target * price[0];
        }
        int take = -10000000;
        int len_rod = n + 1;
        if (len_rod <= target)
            take = price[n] + func(price, n, target - len_rod);
        int not_take = func(price, n - 1, target);
        return Math.max(take, not_take);
    }
}