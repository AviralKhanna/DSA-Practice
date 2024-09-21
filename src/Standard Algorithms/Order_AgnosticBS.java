class Order_AgnosticBS {
    public static void main(String[] args) {
        Order_AgnosticBS ls = new Order_AgnosticBS();
        int[] arr = {123, 43, 7, 6, 5, 4, 3, 2, 1};
        int target = 43;
        int ans = ls.Search(arr, target);
        System.out.println(ans);
    }

    int Search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean asg = arr[start] > arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (asg) {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
