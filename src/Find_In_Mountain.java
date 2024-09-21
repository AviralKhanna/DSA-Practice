//https://leetcode.com/problems/find-in-mountain-array/description/
class Find_In_Mountain {
    public static void main(String[] args) {
        Find_In_Mountain ls = new Find_In_Mountain();
        int[] arr = { 2, 3, 5, 12, 45, 43, 23, 11, 2 };
        int target = 2;
        int peak = ls.Find_peak(arr);
        int ans = ls.AgnosBS(arr, target, 0, peak);
        if (ans != -1) {
            System.out.println(ans);
        } else{
        ans = ls.AgnosBS(arr, target, peak + 1, arr.length - 1);
        System.out.println(ans);}
    }

    int Find_peak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;

            }
        }
        return start;
    }

    int AgnosBS(int[] arr, int target, int start, int end) {
        boolean isarg = arr[start] < arr[end];
        int mid;

        while (start <= end) {
            mid = start + (end-start) / 2;
            if (arr[mid] == target)
                return mid;

            if (isarg) {
                if (arr[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {

                if (arr[mid] > target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }

        return -1;

    }
}