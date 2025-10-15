import java.util.*;
class SBI_Sort {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 1, 44, 34, 32, 1222, 0 };

        // selection_sort(arr);
        // bubble_sort(arr);
        insertion_sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    // //selection_sort
    // public static void selection_sort(int[] nums) {
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         for (int j = i; j < nums.length; j++) {
    //             if (nums[i] > nums[j])
    //                 swap(nums, i, j);
    //         }
    //     }
    // }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // //bubble_sort
    // public static void bubble_sort(int[] arr) {
    //     Boolean isSwap = false;
    //     int n = arr.length;
    //     for (int i = 0; i < n; i++) {
    //         isSwap = false;
    //         for (int j = 0; j < n - 1 - i; j++) {
    //             if (arr[j + 1] < arr[j]) {
    //                 swap(arr, j+1, j);
    //                 isSwap = true;
    //             }
    //         }
    //         if (isSwap == false)
    //             break;
    //     }
    // }

public static void insertion_sort(int[] nums){
    int n= nums.length;
    for(int i=0; i<n; i++)
    {
        int j=i;
        while(j>0 && nums[j-1]>nums[j])
        {
            swap(nums, j-1, j); j--;
        }
    }
}
}