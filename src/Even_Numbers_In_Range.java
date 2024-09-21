class Even_Numbers_In_Range {
    public int[] findEvenNumbers(int[] arr, int start, int end) {
        int count = 0;

        // First pass to count the even numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end && arr[i] % 2 == 0) {
                count++;
                
            }
           
        }
        System.out.println(count);

        // Create an array of the correct size
        int[] result = new int[count];
        int index = 0;

        // Second pass to populate the result array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end && arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Even_Numbers_In_Range enir = new Even_Numbers_In_Range();
        int[] arr = { 2, 3, 4, 7, 8, 10, 15, 18, 20, 25,43,222,2222,4444 }; // Example sorted array
        int start = 5;
        int end = 20;

        int[] result = enir.findEvenNumbers(arr, start, end);

        System.out.print("Even numbers between " + start + " and " + end + ": ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
