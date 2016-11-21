package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.intro;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class DisplayTime implements Runnable {
    public static void main(String[] args) {
        new DisplayTime().run();
    }

    @Override
    public void run() {
        int seconds = inputIntLoop("Enter seconds: ");
        System.out.printf("%ss = %sh, %sm, %ss", seconds, seconds/3600, (seconds/60)%60, seconds%60);
    }
}
