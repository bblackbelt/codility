package com.blackbelt.codility.maximumsliceproblem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by emanuele on 16.05.15.
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 * <p/>
 * Write a function:
 * <p/>
 * int solution(int A[], int N);
 * <p/>
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 * <p/>
 * For example, given array A such that:
 * <p/>
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 * <p/>
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Assume that:
 * <p/>
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MaxSliceSum {
    public int solution(int[] A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int x : A) {
            int tmpSum = sum + x;
            if (tmpSum <= 0) {
                arrayList.add(sum == 0 ? x : max);
                sum = 0;
                max = Integer.MIN_VALUE;
                continue;
            }
            sum += x;
            if (sum > max) {
                max = sum;
            }
        }
        if (sum != 0) {
            arrayList.add(max);
        }
        Collections.sort(arrayList);
        if (arrayList.isEmpty()) {
            return sum;
        }
        return arrayList.get(arrayList.size() - 1);
    }
}
