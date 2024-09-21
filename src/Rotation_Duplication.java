// ROUGH CONCEPT. PLEASE REVISE THOROUGHLY

class Rotation_Duplication {
    public static void main(String[] args) {
        Rotation_Duplication ls = new Rotation_Duplication();
        int[] arr = { 1, 2, 3, 14, 1, 2, 3, 4 };
        int target = 2;
        int ans = ls.Search(arr, target);
        System.out.println(ans); // Should print -1 since 12 is not in the array
    }

    int Search(int[] arr, int target) {
        int pivot = pivot_find(arr);

        // If no pivot is found, the array is not rotated, do a normal binary search
        if (pivot == -1) {
            return Binary_S(arr, target, 0, arr.length - 1);
        }

        // If pivot is found, check if the target is at the pivot
        if (arr[pivot] == target) {
            return pivot;
        }

        // Determine which side to search
        if (arr[0] <= target) {
            return Binary_S(arr, target, 0, pivot - 1);
        } else {
            return Binary_S(arr, target, pivot + 1, arr.length - 1);
        }
    }

    int pivot_find(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
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

        return -1; // Pivot not found, array is not rotated
    }

    int Binary_S(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
