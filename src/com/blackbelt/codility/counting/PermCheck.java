package com.blackbelt.codility.counting;

/**
 * Created by emanuele on 25.03.15.
 */
public class PermCheck {
    public int isPermutation(int[] A) {
        // write your code in Java SE 8
        int[] tmp = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A.length || (++tmp[A[i]] > 1)) {
                return 0;
            }
        }
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] == 0) {
                return 0;
            }
        }
        return 1;
    }
}
