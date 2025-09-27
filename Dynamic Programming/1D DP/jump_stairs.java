
// count ways to reach n stairs, you can eithrr jump 1 or 2
class jump_stairs {
    public static void main(String[] args) {
        int n = 5;
        int jump_two = 0;
        int curr = 0;
        int prev2 = 1;
        int prev1 = 1;
        for (int i = 2; i < n; i++) {
            int jump_one = prev1;
            if (i > 1) {
                jump_two = prev2;
            }
            curr = jump_one + jump_two;
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(prev1);
    }
}
