package com.blackbelt.codility.sorting;

/***
 *
 Task description
 A non-empty zero-indexed array A consisting of N integers is given.The product of triplet(P,Q,R)equates to A[P]*A[Q]*A[R](0 ≤ P<Q<R<N).
 For example,array A such that:
 A[0]=-3
 A[1]=1
 A[2]=2
 A[3]=-2
 A[4]=5
 A[5]=6
 contains the following example triplets:
 (0,1,2),product is −3*1*2= −6
 (1,2,4),product is 1*2*5=10
 (2,4,5),product is 2*5*6=60
 Your goal is to find the maximal product of any triplet.
 Write a function:

 class Solution {
 public int solution(int[] A);
 }
 that,given a non-empty zero-indexed array A,returns the value of the maximal product of any triplet.
 For example,given array A such that:
 A[0]=-3
 A[1]=1
 A[2]=2
 A[3]=-2
 A[4]=5
 A[5]=6
 the function should return 60,as the product of triplet(2,4,5)is maximal.
 Assume that:
 N is an integer within the range[3..100,000];
 each element of array A is an integer within the range[−1,000..1,000].
 Complexity:
 expected worst-case time complexity is O(N*log(N));
 expected worst-case space complexity is O(1),beyond input storage(not counting the storage required for input arguments).

 */

import java.lang.String;

public class MaxProductOfThree {
    private void heapify(int[] A, int size, int index) {
        int leftIndex = (index << 1) + 1;
        int rightIndex = (leftIndex + 1);
        int largeIndex = index;
        if (leftIndex < size && A[leftIndex] > A[largeIndex]) {
            largeIndex = leftIndex;
        }
        if (rightIndex < size && A[rightIndex] > A[largeIndex]) {
            largeIndex = rightIndex;
        }
        if (index != largeIndex) {
            swap(A, largeIndex, index);
            heapify(A, size, largeIndex);
        }
    }

    private void swap(int A[], int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    private void buildHeap(int a[]) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, a.length, i);
        }
    }

    private void heapSort(int a[]) {
        buildHeap(a);
        int size = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, size);
            heapify(a, size, 0);
            size--;
        }
    }

    public int solution(int[] A) {
        heapSort(A);
        int minP = A[0] * A[1] * A[A.length - 1];
        int maxP = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        return maxP > minP ? maxP : minP;
    }


}