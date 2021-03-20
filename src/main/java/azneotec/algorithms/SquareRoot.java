package azneotec.algorithms;

public class SquareRoot {

    public static int mySqrt(int x) {

        /**
         * Step 1: Find the base case.
         * Step 2: Solve for perfect squares using Binary Search
         * Step 3: Solve for imperfect squares like 8
         * Step 4: Solve for 2147395599 using long instead of int
         */

        // Step 1: Find the base case.
        if (x == 0 || x == 1) {
            return x;
        }

        long result = 1;

        long startIdx = 2;
        long endIdx = x;

        // Step 2: Solve for perfect squares using Binary Search

        while (startIdx <= endIdx) {    // loop condition
            long mid = startIdx + (endIdx - startIdx) / 2;   // Guard against java integer overflow while calculating mid point

            long square = mid * mid;

            if (square == x) {
                result = mid;
                break;
            }

            if (square < x) {
                startIdx = mid + 1;
                result = mid;           // Step 3: Solve for imperfect squares like 8
            } else {
                endIdx = mid - 1;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(64));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147395599));
    }
}
