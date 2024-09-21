
// TOUGH QUESTION 
// REMEMBER THIS IS THE WRONG APPROACH FOR ROTATIONAL
//leetcode.com/problems/search-in-rotated-sorted-array/submissions/1372517783/
// PEAK DIVIDING AND PASSING IS THE WRONG APPROACH

//     public static void main(String[] args) {
//         Rotated_Sorted_Array ls = new Rotated_Sorted_Array();
//         int[] arr = {5,1,3};
//         int target = 5;
//         int ans = ls.search(arr, target);
//         System.out.println(ans);

//     }
// int search(int[] arr, int target){
//         int peak = find_peak(arr);
//         int ans = Binary_Search(arr, target, 0, peak);
//         if (ans != -1) {
//             return ans;
//         } else {
//             ans = Binary_Search(arr, target, peak+1, arr.length - 1);
//             return ans;
//         }

//     }

//     int find_peak(int[] arr) {
//         int start = 0;
//         int end = arr.length - 1;
//         while (start < end) {
//             int mid = start + (end - start) / 2;
//             if (arr[mid] < arr[mid + 1])
//                 start = mid + 1;
//             else
//                 end = mid;

//         }
//         return start;

//     }

//     int Binary_Search(int[] arr, int target, int start, int end) {
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             if (arr[mid] < target) {
//                 start = mid + 1;
//             } else if (arr[mid] > target) {
//                 end = mid - 1;

//             } else
//                 return mid;
//         }
//         return -1;
//     }

// }
class Rotated_Sorted_Array {
    public static void main(String[] args) {
        Rotated_Sorted_Array ls = new Rotated_Sorted_Array();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 3, 4, 15, 6 };
        int target = 6;
        int ans = ls.search(arr, target);

        System.out.println(ans); // Expected output: 3 or 8 depending on the pivot
    }

    int search(int[] arr, int target) {
        int pivot = pivot_find(arr);

        // If no pivot is found, just perform binary search on the entire array
        if (pivot == -1) {
            return Binary_Search(arr, target, 0, arr.length - 1);
        }

        // If the target is the pivot element
        if (arr[pivot] == target) {
            return pivot;
        }

        // If target is in the left sorted array
        if (target >= arr[0]) {
            return Binary_Search(arr, target, 0, pivot - 1);
        } else {
            // If target is in the right sorted array
            return Binary_Search(arr, target, pivot + 1, arr.length - 1);
        }
    }

    int pivot_find(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Case 1: Check if mid is the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // Case 2: Check if mid-1 is the pivot
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // Case 3: If the left part is sorted, move to the right part
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                // Case 4: If the right part is sorted, move to the left part
                end = mid - 1;
            }
        }

        // No pivot found, return -1
        return -1;
    }

    int Binary_Search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
