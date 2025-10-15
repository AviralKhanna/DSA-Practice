
// Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"] 
// list2 = ["KFC","Shogun","Burger King"]
// Output: ["Shogun"]
// Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.

import java.util.*;

class Min_sum_index {
    public static void main(String[] args) {
        String[] s1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] s2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

        HashMap<String, Integer> hash1 = new HashMap<>();

        for (int i = 0; i < s1.length; i++) {
            if (!hash1.containsKey(s1[i])) {
                hash1.put(s1[i], i);
            }
        }
        // System.out.println(hash1);
        ArrayList<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        // int n= (s1.length < s2.length)? s2.length:s1.length;
        for (int i = 0; i < s2.length; i++) {
            if (hash1.containsKey(s2[i])) {
                sum = i + hash1.get(s2[i]);

                if (sum < min) {
                    ans.clear();
                    ans.add(s2[i]);
                    min = sum;
                } else if (sum == min)
                    ans.add(s2[i]);
            }
        }
        System.out.println(min);
        System.out.println(ans);
    }
}