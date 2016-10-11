package com.karmios.nat.ComputingWork;

import java.util.Arrays;

/**
 * This is just my random code ramblings.
 * Ignore this file.
 */

public class Tests {
    public static void main(String[] args) {
        int[] foo = new int[5];
        bar(foo);
        System.out.println(Arrays.toString(foo));
    }

    static void bar(int[] foo) {
        foo[0] = 1;
    }
}
