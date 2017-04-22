package com.karmios.nat.computingwork.paper1.computational_theory;

import org.apache.commons.lang3.tuple.Pair;

public class Task2 {
    public Pair<Integer, Integer> intDiv(int x, int y) {
        int r = x;
        int q = 0;
        while (r >= y) {
            r = r - y;
            q++;
        }
        return Pair.of(r, q);
    }
}
