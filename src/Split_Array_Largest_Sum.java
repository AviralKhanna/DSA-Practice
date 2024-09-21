class Split_Array_Largest_Sum {
    //LEETCODE HARD https://leetcode.com/problems/split-array-largest-sum/
    // to understand
    private int getMax(int[] nums){
        int max = nums[0];
        for(int num:nums){
            max = Math.max(max,num);
        }
        return max;
    }
    
    private int getSum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }
    
    private boolean canSplit(int[] nums,int k,int maxSum){
        int subArrayCount = 1;
        int currentSum = 0;
        for(int num :nums){
            if(currentSum+num > maxSum){
                subArrayCount++;
                currentSum = num;
                if(subArrayCount>k){
                    return false;
                }
            }else{
                currentSum +=num;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int left = getMax(nums);
        int right = getSum(nums);
        while(left<right){
            int mid = left + (right-left)/2;
            if(canSplit(nums,k,mid)){
                right=mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}