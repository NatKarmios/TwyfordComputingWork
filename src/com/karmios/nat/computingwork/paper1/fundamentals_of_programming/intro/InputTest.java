package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.intro;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class InputTest implements Runnable {
    public static void main(String[] args) {
        new InputTest().run();
    }

    @Override
    public void run() {
        System.out.println("Hello, " + input("Enter your name: ") + "!");
    }
}
