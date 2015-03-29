package com.blackbelt.codility.counting;

/**
 * Created by emanuele on 27.03.15.
 * <p/>
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p/>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:
 * <p/>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 * <p/>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the values of the counters after each consecutive operation will be:
 * <p/>
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 * <p/>
 * Assume that the following declarations are given:
 * <p/>
 * struct Results {
 * int * C;
 * int L;
 * };
 * <p/>
 * Write a function:
 * <p/>
 * struct Results solution(int N, int A[], int M);
 * <p/>
 * that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 * <p/>
 * The sequence should be returned as:
 * <p/>
 * a structure Results (in C), or
 * a vector of integers (in C++), or
 * a record Results (in Pascal), or
 * an array of integers (in any other programming language).
 * For example, given:
 * <p/>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N+M);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                result[0] = max;
                for (int j = 1; j < N; j += j) {
                    System.arraycopy(result, 0, result, j, j + j < N ? j : N - j);
                }
                continue;
            }
            if (++result[A[i] - 1] > max) {
                max = result[A[i] - 1];
            }
        }
        return result;
    }

}
