package azneotec.datastructures;

import java.util.Arrays;

public class MaxPQ {

    private Integer[] pq;
    private int n;

    public MaxPQ(Integer[] input) {
        this.n = input.length;
        pq = Arrays.copyOf(input, n);

        // heapify phase
        for (int k = n / 2; k >= 0; k--) {
            sink(k);
        }

    }

    private void sink(int P) {

        while ((2 * P) + 1 <= n - 1) {
            int leftChild = (2 * P) + 1;
            int rightChild = (2 * P) + 2;

            int greaterChild = leftChild;

            if (leftChild < n - 1 && less(leftChild, rightChild)) {
                greaterChild = rightChild;
            }

            if (!less(P, greaterChild)) break;
            exch(P, greaterChild);
            P = greaterChild;
        }

    }

    public int size() {
        return n;
    }

    private void exch(int i, int j) {
        Integer tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    public void show() {
        Integer[] arr = Arrays.copyOfRange(pq, 0, n);
        System.out.println(Arrays.toString(arr));
    }


    public void sort() {
        while (n > 0) {
            n--;
            exch(0, n);
            sink(0);
        }

        n = pq.length;
    }

    public static void main(String[] args) {

        Integer[] input = new Integer[10];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }

        System.out.println(Arrays.toString(input));

        MaxPQ pq = new MaxPQ(input);
        pq.show();
        pq.sort();
        System.out.println("Sorted PQ");
        pq.show();

    }

}
