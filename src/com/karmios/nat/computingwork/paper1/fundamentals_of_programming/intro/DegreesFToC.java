package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.intro;

import java.util.function.Consumer;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class DegreesFToC implements Runnable {
    public static void main(String[] args) {
        new DegreesFToC().run();
    }

    @Override
    public void run() {
        System.out.println(((5.0/9.0) * Double.valueOf(
                inputLoop("Enter Degrees Fahrenheit: ", runsCleanly((Consumer<String>) Double::valueOf)))) + "°C");
    }
}
