import java.util.*;

class Intersection_of_two_arrays {
    public static void main(String[] args) {
        int[] array1 = { 2, 323, 211, 4, 3 };
        int[] array2 = { 1, 323, 211, 42, 13 };
        Set<Integer> myset = new HashSet<Integer>();
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                myset.add(array1[i]);
                i++;
                j++;
            }
            else if(array1[i]<array2[j])

        {
            i++;
        }
        else j++;
            
        }
        System.out.println(myset);
    }
}