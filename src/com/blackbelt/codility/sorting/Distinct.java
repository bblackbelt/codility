package com.blackbelt.codility.sorting;

/**
 * Created by emanuele on 23.03.15.
 * Write a function
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * For example, given array A consisting of six elements such that:
 * <p/>
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * <p/>
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class Distinct {

    private void sort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int cutIndex = partition(a, lo, hi);
            sort(a, lo, cutIndex - 1);
            sort(a, cutIndex + 1, hi);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int pivotIndex = lo + (hi - lo)/2;
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, hi);
        int cutIndex = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (a[i] < pivot) {
                swap(a, ++cutIndex, i);
            }
        }
        swap(a, ++cutIndex, hi);
        return cutIndex;
    }

    private void swap(int[] a, int first, int end) {
        int tmp = a[first];
        a[first] = a[end];
        a[end] = tmp;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        sort(A, 0, A.length - 1);
        int x = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {

            if (x != A[i]) {
                counter++;
                x = A[i];
            }
        }
        return counter;
    }
}
