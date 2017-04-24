package com.karmios.nat.computingwork.paper1.misc_exercises._2017_february_24;

import static com.karmios.nat.computingwork.utils.Utils.*;

class Exercise implements Runnable {
    @Override
    public void run() {
        int answer = 0;
        int column = 8;
        do {
            int bit = inputIntLoop(
                    "Enter bit value: ",
                    "You must enter a 0 or a 1!",
                    inBounds(2)
            );
            answer += (column * bit);
            column /= 2;
        } while (column >= 1);
        System.out.printf("Decimal value is: %s\n", answer);
    }

    public static void main(String[] args) {
        new Exercise().run();
    }
}
