class InfiniteArray_BS {
    public static void main(String[] args) {
        InfiniteArray_BS ls = new InfiniteArray_BS();
        int[] arr = { 1, 3, 44, 56, 66, 78, 89, 90, 111, 123 };
        int target = 33;
        int answer = ls.ans(arr, target);
        System.out.println(answer);

    }

    int ans(int[] arr, int target) {
        int mid;
        int start = 0;
        int end = 1;
        if (arr[end] < target) {
            int temp = end + 1;
            // formula to have the next search area of 2*boxsize.

            end = end + (end - start + 1) * 2;
            start = temp;
        }

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;

        }
        return -1;

    }
}