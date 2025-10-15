import java.util.*;
class contains_duplicate
{
    public static void main(String[] args)
    {
        int[] arr= {1,2,3,5,7};
        Set<Integer> myset = new HashSet<>();

        for(int num: arr)
        {
            myset.add(num);
        }
        System.out.println(arr.length != myset.size());
    }
}