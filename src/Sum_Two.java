import java.util.*;
class Sum_Two {
    public int[] twoSum(int[] nums, int target) 
    {
// note for logic. "j - i" is a logic for traversal and sum. 
// i will run from 1 to < length  
// j will run from i to < length.
// https://leetcode.com/problems/two-sum/description/

        for(int i = 1; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(nums[j] + nums[j - i] == target) {
                    return new int[]{j,j - i};
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Sum_Two solution = new Sum_Two(); 
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(arr, target); 
        System.out.println(Arrays.toString(result)); 
    }
}
