package com.blackbelt.codility.prefixsums;

/**
 * Created by emanuele on 29.03.15.
 * <p/>
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p/>
 * For example, array A such that:
 * <p/>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p/>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p/>
 * Write a function:
 * <p/>
 * int solution(int A[], int N);
 * <p/>
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 * <p/>
 * For example, given array A such that:
 * <p/>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
public class MinAvgTwoSlice {

    public int solution(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        float minAvg = Float.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < A.length - 2; i++) {
            float tmp = (A[i] + A[i + 1]);
            if ((tmp / 2f) < minAvg) {
                minAvg = tmp / 2f;
                index = i;
            }
            tmp = (A[i] + A[i + 1] + A[i + 2]);
            if ((tmp / 3f) < minAvg) {
                minAvg = tmp / 3f;
                index = i;
            }
        }
        float last = (A[A.length - 2] + A[A.length - 1]) / 2f;
        if (last < minAvg) {
            return A.length - 2;
        }
        return index;
    }

}
