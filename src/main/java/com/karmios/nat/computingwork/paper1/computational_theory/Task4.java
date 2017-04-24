package com.karmios.nat.computingwork.paper1.computational_theory;

import java.util.ArrayList;

class Task4 {
    static int[] primeFactors(int n) {
        if (n<2) throw new IllegalArgumentException();

        ArrayList<Integer> results = new ArrayList<>();

        int sqrtOfOn = (int) Math.sqrt(n);

        for (int i=2; i<=sqrtOfOn; i++)
            while (n % i == 0) {
                results.add(i);
                n /= i;
            }
        if (n>1) results.add(n);

        return results.stream().mapToInt(x -> x).toArray();
    }
}
