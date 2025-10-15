// LIS Using Binary Searching. TC= O(nlogn) SC= 0(n)

// LOWER BOUND BS

import java.util.*;

class LIS_BS {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 8, 4, 5, 6, -1, 9 };
        // int target = 9;
        // int ans = lowerbound(arr, target);
        int ans = LIS(arr);
        System.out.println(ans);
    }

    public static int lowerbound(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else if (arr.get(mid) < target) {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int LIS(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        int len = 1;
        for (int i = 1; i < arr.length; i++) {         //O(NlogN)
            if (ans.get(ans.size() - 1) < arr[i]) {
                ans.add(arr[i]);
                len++;
            } else {
                int lowerbound = lowerbound(ans, arr[i]);
                ans.set(lowerbound, arr[i]);
            }
        }
        return len;
    }
}