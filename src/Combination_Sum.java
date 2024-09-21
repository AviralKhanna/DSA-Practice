// UNDERSTAND THIS CODE 

import java.util.*;
class Combination_Sum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 6;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();  // This will store the final result
        findCombinations(0, candidates, target, result, new ArrayList<>());  // Start finding combinations
        ret// UNDERSTAND THIS CODE

import java.util.*;
        class Combination_Sum {
            public static void main(String[] args) {
                int[] candidates = {2, 3, 6, 7};
                int target = 6;
                List<List<Integer>> result = combinationSum(candidates, target);
                System.out.println(result);
            }
            public static List<List<Integer>> combinationSum(int[] candidates, int target) {
                List<List<Integer>> result = new ArrayList<>();  // This will store the final result
                findCombinations(0, candidates, target, result, new ArrayList<>());  // Start finding combinations
                return result;  // Return the result when all combinations are found
            }

            // Recursive helper function to find all combinations
            private static void findCombinations(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> currentCombination) {
                // Base case: if we've gone through all elements
                if (index == candidates.length) {
                    // If target is zero, we found a valid combination
                    if (target == 0) {
                        result.add(new ArrayList<>(currentCombination));  // Add the current combination to the result. adding list of correct combinations to list.
                    }
                    return;  // Stop the recursion
                }

                // Case 1: Include the current element if it's <= target
                if (candidates[index] <= target) {
                    currentCombination.add(candidates[index]);  // Add the current candidate to the current combination
                    // Recursively try to find combinations with the same candidate again (index remains the same)
                    findCombinations(index, candidates, target - candidates[index], result, currentCombination);
                    currentCombination.remove(currentCombination.size() - 1);  // Backtrack: remove the last added element
                }

                // Case 2: Move to the next element (index + 1)
                findCombinations(index + 1, candidates, target, result, currentCombination);
            }
        }urn result;  // Return the result when all combinations are found
    }

    // Recursive helper function to find all combinations
    private static void findCombinations(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> currentCombination) {
        // Base case: if we've gone through all elements
        if (index == candidates.length) {
            // If target is zero, we found a valid combination
            if (target == 0) {
                result.add(new ArrayList<>(currentCombination));  // Add the current combination to the result. adding list of correct combinations to list.
            }
            return;  // Stop the recursion
        }

        // Case 1: Include the current element if it's <= target
        if (candidates[index] <= target) {
            currentCombination.add(candidates[index]);  // Add the current candidate to the current combination
            // Recursively try to find combinations with the same candidate again (index remains the same)
            findCombinations(index, candidates, target - candidates[index], result, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);  // Backtrack: remove the last added element
        }




        // Case 2: Move to the next element (index + 1)
        findCombinations(index + 1, candidates, target, result, currentCombination);
    }
}