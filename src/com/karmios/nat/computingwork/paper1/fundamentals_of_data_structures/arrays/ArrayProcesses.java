package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.arrays;

import java.util.*;
import java.util.stream.Collectors;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class ArrayProcesses implements Runnable {

    @SuppressWarnings({"SuspiciousMethodCalls", "OptionalGetWithoutIsPresent"})
    public static void main(String[] args) {
        new ArrayProcesses().run();
    }

    @Override
    public void run() {
//        // Initialise an array with input values
//        Scanner in = new Scanner(System.in);
//        int[] inputVals = new int[3];
//        for (int i = 0; i < 3; i++) {
//            System.out.print("Enter value for index " + i + ": ");
//            inputVals[i] = in.nextInt();
//        }
//        System.out.println(arrays.toString(inputVals));

        // Initialise an array with input values
        int[] randVals = new int[3];
        for (int i = 0; i < 3; i++) {
            randVals[i] = rng.nextInt(10);
        }
        System.out.println(Arrays.toString(randVals));

        // Print each item
        Arrays.stream(randVals).forEach(System.out::println);

        // Get the sum
        System.out.println("Sum: " + Arrays.stream(randVals).sum());

        // Largest number
        int max;
        //noinspection OptionalGetWithoutIsPresent
        System.out.println("Largest: " + (max=Arrays.stream(randVals).max().getAsInt()));

        // Index of largest
        System.out.println(max);
        System.out.println("Index of Largest: " +
                new ArrayList<>(Arrays.stream(randVals).boxed().collect(Collectors.toList())).indexOf(max));
    }
}
