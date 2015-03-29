package com.blackbelt.codility.counting;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by emanuele on 26.03.15.
 */
public class MissingInteger {
    public int solution(int[] A) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int x : A) {
            if (x < 0) {
                continue;
            }
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
            set.add(x);
        }
        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }
}
