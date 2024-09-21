class Ceiling_Number {
    public static void main(String[] args) {
        Ceiling_Number ls = new Ceiling_Number();
        int[] arr = {2, 4, 6, 8, 12};
        int target = 9;
        int ans = ls.Search(arr, target);
        System.out.println(ans);
    }

    int Search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (target > arr[end]) {
            return -1; }

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

        return start; // return end for floor value 



        
    }
}
