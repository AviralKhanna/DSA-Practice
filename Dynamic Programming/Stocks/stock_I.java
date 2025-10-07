
public class stock_I {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 2, 4, 3, 6, 3 };
        int mini = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }
        System.out.println(profit);
    }
}