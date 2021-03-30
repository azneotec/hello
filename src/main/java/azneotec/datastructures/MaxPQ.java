package azneotec.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

    public void insert(int key) {

        if (n == pq.length) {
            resize(2 * pq.length);
        }
        pq[n] = key;
        swim(n++);

    }

    public Integer deleteMax() {
        Integer max = pq[0];
        n--;
        exch(0, n);
        sink(0);
        pq[n] = null;
        if (n >= 0 && n == (pq.length - 1) / 4) resize((pq.length - 1 / 2));
        return max;
    }

    private void swim(int child) {
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (less(parent, child)) {
                show();
                exch(parent, child);
                child = parent;
            } else {
                break;
            }
        }
    }

    private void resize(int capacity) {

        Integer[] temp = new Integer[capacity];

        for (int i = 0; i < pq.length; i++) {
            temp[i] = pq[i];
        }
        pq = temp;

    }


    public int size() {
        return n;
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

    private void exch(int i, int j) {
        Integer tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    public static void main(String[] args) {

        Integer[] input = new Integer[10];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }

        System.out.println("Original Array");
        System.out.println(Arrays.toString(input));

        MaxPQ pq = new MaxPQ(input);
        System.out.println("Heapified Array");
        pq.show();

        System.out.println("Insert element: 10");
        pq.insert(10);
        pq.show();

        System.out.println("Delete max element");
        System.out.println(pq.deleteMax());
        pq.show();

//        pq.sort();
//        System.out.println("Sorted PQ");
//        pq.show();

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        minPQ.offer(10);
        minPQ.offer(5);
        minPQ.offer(11);

        System.out.println(minPQ);

    }

}
