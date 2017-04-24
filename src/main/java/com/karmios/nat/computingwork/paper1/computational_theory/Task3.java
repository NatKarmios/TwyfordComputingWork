package com.karmios.nat.computingwork.paper1.computational_theory;

import java.util.ArrayList;

class Task3 {
    static int[] primeFactors(int n) {
        if (n<1) throw new IllegalArgumentException();
        ArrayList<Integer> results = new ArrayList<>();

        for (int i=2; i<=n; i++) {
            while (n%i == 0) {
                results.add(i);
                n /= i;
            }
        }

        return results.stream().mapToInt(x -> x).toArray();
    }
}
