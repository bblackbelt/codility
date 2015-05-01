package com.blackbelt.codility.leader;

/**
 * Created by emanuele on 01.05.15.
 * A non-empty zero-indexed array A consisting of N integers is given.
 * <p/>
 * The leader of this array is the value that occurs in more than half of the elements of A.
 * <p/>
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 * <p/>
 * For example, given array A such that:
 * <p/>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 * <p/>
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 * <p/>
 * Write a function:
 * <p/>
 * int solution(int A[], int N);
 * <p/>
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.
 * <p/>
 * For example, given:
 * <p/>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * the function should return 2, as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
public class EquiLeader {
    public int solution(int[] A) {
        int value = 0;
        int counter = 0;
        for (int x : A) {
            if (counter == 0) {
                ++counter;
                value = x;
            } else {
                if (x == value) {
                    ++counter;
                } else {
                    --counter;
                }
            }
        }
        int candidate = -1;
        if (counter > 0) {
            candidate = value;
        }
        int total = 0;
        for (int x : A) {
            if (x == candidate) {
                ++total;
            }
        }
        if (total < A.length / 2) {
            return 0;
        }
        int leftLeader = 0;
        counter = 0;
        for (int i = 0; i < A.length; i++) {
            value = A[i];
            if (value == candidate) {
                ++leftLeader;
            }
            int rightLeader = total - leftLeader;
            if (leftLeader > (i + 1) / 2 && rightLeader > (A.length - i - 1) / 2) {
                ++counter;
            }
        }
        return counter;
    }
}
