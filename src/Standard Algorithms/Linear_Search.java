// import java.util.*;
public class Linear_Search {
    int search(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        Linear_Search ls = new Linear_Search();
        int[] arr = { 1, 3, 44, 32, 4, 22, -1, -34, 0, 56, 0 };
        int target = -1;
        int result = ls.search(arr, target);
        System.out.println(result);
    }
}
