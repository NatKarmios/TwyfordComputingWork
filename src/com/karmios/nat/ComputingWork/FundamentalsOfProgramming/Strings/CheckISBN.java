package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"WeakerAccess", "ConstantConditions"})
public class CheckISBN {

    public static void main(String[] args) {
        check_digit_action a = check_digit_action.GET;
        System.out.print("Enter ISBN: ");
        String str = new Scanner(System.in).nextLine();

        switch (a){
            case VERIFY:
                System.out.println(verifyISBN(str) ? "Valid" : "Invalid");
                break;
            case GET:
                System.out.println(getCheckDigit(str));
                break;
        }

    }


    public enum check_digit_action {
        VERIFY, GET
    }


    public static boolean verifyISBN (String isbn) {
        return weightedTotal(isbn) % 11 == 0;
    }

    public static int getCheckDigit(String isbn) {
        return (11 - (weightedTotal(isbn, false) % 11)) % 11;
    }


    private static int weightedTotal(String isbn) {
        return weightedTotal(isbn, true);
    }

    private static int weightedTotal(String isbn, boolean complete) {
        checkValidInput(isbn, complete);
        final AtomicInteger mult = new AtomicInteger(isbn.length() + (complete ? 0 : 1));
        final AtomicInteger total = new AtomicInteger(0);

        isbn.chars().forEach(x -> total.addAndGet(((x-48)*mult.getAndDecrement())));

        return total.get();
    }

    private static void checkValidInput(String isbn, boolean complete) throws NumberFormatException {
        if (isbn.chars().anyMatch(n -> n<48 || n >=58))
            throw new NumberFormatException("ISBN must only contain digits.");

        if (!Arrays.asList(new Integer[]{10, 13}).contains(isbn.length() + (complete ? 0 : 1)))
            throw new NumberFormatException(
                    String.format("%somplete ISBN must be %s or %s digits long; %s digits given.",
                            (complete ? "C" : "Inc"),
                            (10 - (complete ? 0 : 1)),
                            (13 - (complete ? 0 : 1)),
                            isbn.length())
            );
    }

}
