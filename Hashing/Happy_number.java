class Happy_number {
    public static void main(String[] args) {
        int num = 19;
        int slow = num;
        int fast = num;

        while (true) {
            slow = sum_of_squares(slow);                   // move 1 step
            fast = sum_of_squares(sum_of_squares(fast));   // move 2 steps

            if (slow == fast) break; // either both meet at 1 or in a cycle
        }

        if (slow == 1) {
            System.out.println("True (Happy Number!)");
        } else {
            System.out.println("False (Unhappy Number)");
        }
    }

    public static int sum_of_squares(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
