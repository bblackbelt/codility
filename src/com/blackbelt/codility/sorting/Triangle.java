package com.blackbelt.codility.sorting;

/**
 * Created by emanuele on 23.03.15.
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p/>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * <p/>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 * <p/>
 * Write a function:
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 * <p/>
 * For example, given array A such that:
 * <p/>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 * <p/>
 * A[0] = 10    A[1] = 50    A[2] = 5
 * A[3] = 1
 * the function should return 0.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */

public class Triangle {

    private void heapify(int[]a, int size, int index) {
        int leftIndex = (index << 1) + 1;
        int rightIndex = leftIndex + 1;
        int largestIndex = index;
        if (leftIndex < size && a[leftIndex] > a[largestIndex]) {
            largestIndex = leftIndex;
        }
        if (rightIndex < size && a[rightIndex] > a[largestIndex]) {
            largestIndex = rightIndex;
        }
        if (index != largestIndex) {
            swap(a, largestIndex, index);
            heapify(a, size, largestIndex);
        }
    }

    private void buildHeap(int a[]) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, a.length, i);
        }
    }

    private void heapSort(int[] a) {
        buildHeap(a);
        int swapIndex = a.length - 1;
        for (int i =  a.length - 1; i >= 0; i--) {
            swap(a, 0, swapIndex);
            heapify(a, swapIndex, 0);
            swapIndex--;
        }
    }
    private void swap(int[] array, int firstIndex, int endIndex) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[endIndex];
        array[endIndex] = tmp;
    }

    public int solution(int[] a) {
        // write your code in Java SE 8
        heapSort(a);

        for (int i = 0; i < a.length - 2; i++) {
            int p = a[i];
            int q = a[i + 1];
            int r = a[i + 2];
            if ((p+q) > r) {
                return 1;
            }
        }
        return 0;
    }
}
