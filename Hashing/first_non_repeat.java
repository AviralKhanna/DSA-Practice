
// First non-repeating character in a string.
// Input: s = "aviral"
// Output: 2 (v)
import java.util.*;

public class first_non_repeat {
    public static void main(String[] args) {
        String s = "siddhi";
        LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!hashmap.containsKey(s.charAt(i))) {
                hashmap.put(s.charAt(i), 1);
            } else {
                hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashmap.get(ch) == 1) {
                System.out.println(i + "  -->  " + s.charAt(i));
                break;
            }
        }

    }
}