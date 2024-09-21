class Binary_Search
{
    public static void main(String[] args) {
        Binary_Search ls= new Binary_Search();
        int[] arr= {2,4,6,8,12,14,16,111,134,1578};
        int target = 134;
        int ans = ls.Search(arr, target);
        System.out.println(ans);

    }
    int Search(int[] arr, int target)
    {
        int start =0;
        int mid;
        int end = arr.length-1;
        while (start<=end)
        {
            mid= start+ (end-start)/2;
            if (arr[mid]== target)
            return mid;
            else 
            if (arr[mid]> target)
            end = mid-1;
            else 
            start = mid +1;


        }
        return -1;
// return letters[start % letters. length]; to return 1st index after last. like a circle.


    }
}