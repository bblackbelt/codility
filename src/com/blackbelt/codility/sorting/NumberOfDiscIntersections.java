package com.blackbelt.codility.sorting;

/**
 * Created by emanuele on 24.03.15.
 * <p/>
 * Given an array A of N integers, we draw N discs in a 2D plane such that the I-th disc is centered on (0,I) and has a radius of A[I]. We say that the J-th disc and K-th disc intersect if J ≠ K and J-th and K-th discs have at least one common point.
 * <p/>
 * Write a function:
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given an array A describing N discs as explained above, returns the number of pairs of intersecting discs. For example, given N=6 and:
 * <p/>
 * A[0] = 1  A[1] = 5  A[2] = 2
 * A[3] = 1  A[4] = 4  A[5] = 0
 * intersecting discs appear in eleven pairs of elements:
 * <p/>
 * 0 and 1,
 * 0 and 2,
 * 0 and 4,
 * 1 and 2,
 * 1 and 3,
 * 1 and 4,
 * 1 and 5,
 * 2 and 3,
 * 2 and 4,
 * 3 and 4,
 * 4 and 5.
 * so the function should return 11.
 * <p/>
 * The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class NumberOfDiscIntersections {

    public static O O;

    public static class O {
        public static  int x = 1;
    }

    public static final int MAX_INTERSECTIONS = 10000000;

    private void heapify(long a[], int index, int size) {
        int leftIndex = (index << 1) + 1;
        int rightIndex = leftIndex + 1;
        int largestIndex = index;
        if (leftIndex < size && a[leftIndex] > a[largestIndex]) {
            largestIndex = leftIndex;
        }
        if (rightIndex < size && a[rightIndex] > a[largestIndex]) {
            largestIndex = rightIndex;
        }
        if (largestIndex != index) {
            swap(a, index, largestIndex);
            heapify(a, largestIndex, size);
        }
    }

    private void buildHeap(long a[]) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }
    }

    private void heapSort(long[] a) {
        buildHeap(a);
        int lastSwapIndex = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, lastSwapIndex, 0);
            heapify(a, 0, lastSwapIndex);
            lastSwapIndex--;
        }
    }

    private void swap(long[] a, int o, int q) {
        long tmp = a[o];
        a[o] = a[q];
        a[q] = tmp;
    }


    private int getIntersections(int a[]) {
        long lo[] = new long[a.length];
        long hi[] = new long[a.length];
        for (int i = 0; i < lo.length; i++) {
            lo[i] = ((long) i - (long) a[i]);
        }
        for (int i = 0; i < hi.length; i++) {
            hi[i] = ((long) a[i] + (long) i);
        }
        heapSort(lo);
        heapSort(hi);

        int j;
        int c = 0;
        for (int i = 0; i < hi.length; i++) {
            for (j = i + 1; j < lo.length && hi[i] >= lo[j]; ) {
                j++;
            }
            c += j - i - 1;
        }
        if (c > MAX_INTERSECTIONS)
            return -1;
        return c;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        return getIntersections(A);

    }

}
