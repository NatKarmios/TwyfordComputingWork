package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.mid_term_test.recursion;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Power {
    public static int power(int base, int pow) {
        return pow == 1 ? base : base*power(base, pow-1);
    }
}
