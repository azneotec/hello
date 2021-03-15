package azneotec.algorithms;

import java.util.Arrays;

public class BinarySearch {

    /**
     In Java, object1.compareTo(object2)
     -1  -> object1 value < object2 value
     0   -> object1 value = object2 value
     1   -> object1 value > object2 value
     **/
    public static int search(Comparable[] A, Comparable target) {

        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int comparisonResult = A[mid].compareTo(target);

            if (comparisonResult == 0)      return mid;
            else if (comparisonResult < 0) lo = mid + 1;
            else                            hi = mid - 1;
        }

        return -1;
    }

    /**
         BONUS INTERVIEW QUESTION: Sorted Shifted Array with Binary search

         GIVEN: A = [3, 4, 5, 1, 2], find the the target: 2
         Runtime Complexity: O(logN) where N is length of Array A

     */

    public static int shiftedBinarySearch(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midElement = A[mid];

            if (target == midElement) return mid;

            int leftNum = A[lo];
            int rightNum = A[hi];

            if (leftNum <= midElement) {
                if (target < midElement && target >= leftNum) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > midElement && target <= rightNum) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }

        return -1;

    }

    public static void main(String[] args) {
//        Integer[] integers = {1,2,3,4,5,6};
//        System.out.println(search(integers, 3));
//        System.out.println(search(integers, 7));
//
//        String[] strings = {"-1", "1","2","3","4","5","6"};
//        System.out.println(search(strings, "-1"));
//        System.out.println(search(strings, "5"));
//        System.out.println(search(strings, "-10"));

        int[] A = {3, 4, 5, 6, 1, 2};
        System.out.println(Arrays.toString(A));
        System.out.println(shiftedBinarySearch(A, 2));
        System.out.println(shiftedBinarySearch(A, 6));
        System.out.println(shiftedBinarySearch(A, 7));
    }

}
