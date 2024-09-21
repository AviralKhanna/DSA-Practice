import java.util.*;
// 2 pointer question concept. 
//https://leetcode.com/problems/3sum-closest/description/s

class Closest_three_Sum {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE / 2;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Closest_three_Sum solution = new Closest_three_Sum();
        int[] nums = { -1, 3, 2, 2, 1, -4 };
        int target = 1;
        int result = solution.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
