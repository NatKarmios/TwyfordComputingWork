package com.karmios.nat.computingwork.paper1.computational_theory;

import static java.util.Arrays.stream;

class Task1 {
    static int maximum(int... ints) {
        if (ints.length <= 1) throw new IllegalArgumentException();

        int maximum = ints[0];
        for (int i = 1; i < ints.length; i++)
            if (maximum < ints[i])
                maximum = ints[i];

        return maximum;
    }

    // Faster solution
    static int maximum2(int... ints) {
        return stream(ints).max().orElseThrow(IllegalArgumentException::new);
    }
}
