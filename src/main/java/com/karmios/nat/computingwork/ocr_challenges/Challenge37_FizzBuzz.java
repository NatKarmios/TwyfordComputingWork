package com.karmios.nat.computingwork.ocr_challenges;

import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;

class Challenge37_FizzBuzz {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, inputIntLoop("What number to go up to? ",
                                                "You must enter a natural number!", x -> x>0))
                .mapToObj(i -> "" + ((i+1)%3==0 ? "Fizz" : "") + ((i+1)%5==0 ? "Buzz" : "") +
                        ((i+1)%3!=0&&(i+1)%5!=0 ? i+1 : ""))
                .forEach(System.out::println);
    }
}
