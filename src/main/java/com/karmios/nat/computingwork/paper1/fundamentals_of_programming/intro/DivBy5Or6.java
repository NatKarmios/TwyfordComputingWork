package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.intro;

import static com.karmios.nat.computingwork.utils.Utils.*;

class DivBy5Or6 implements Runnable {
    public static void main(String[] args) {
        new DivBy5Or6().run();
    }

    @Override
    public void run () {
        int num = inputIntLoop("Enter an integer: ");

        System.out.printf("\n5 and 6: %s", num%30==0);
        System.out.printf("\n5 xor 6: %s", num%5==0 ^ num%6==0);
        System.out.printf("\n5 or 6: %s", num%5==0 || num%6==0);
    }
}
