class Rotation_count {
    public static void main(String[] args) {
        Rotation_count la = new Rotation_count();
        int[] arr = { 5, 6, 7, 1, 2, 3, 4 };
        int ans = la.pivot_find(arr);
        System.out.println(ans + 1);
    }

    int pivot_find(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }

            // Handle duplicates
            if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                // Skip duplicates
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // Left side is sorted, so pivot must be on the right side
            else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }

}