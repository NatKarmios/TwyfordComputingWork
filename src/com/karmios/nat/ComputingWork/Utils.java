package com.karmios.nat.ComputingWork;

import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Utils {
    private static final Scanner sc = new Scanner(System.in);

    public static final IntPredicate INT_TRUE = x -> true;
    public static final Predicate<String> STRING_TRUE = x -> true;

    public static String getDir(Class cls) {
        String sep = FileSystems.getDefault().getSeparator();
        return System.getProperty("user.dir") + sep + "src" + sep + cls.getPackage().getName().replace(".", sep) + sep;
    }

    // <editor-fold desc="input()">

    public static String input (String prompt, Predicate<String> condition) throws InputMismatchException {
        System.out.print(prompt);
        String input = sc.nextLine();
        if (!condition.test(input)) throw new InputMismatchException();
        return input;
    }

    public static String input (Predicate<String> condition) throws InputMismatchException {
        return input("", condition);
    }

    public static String input (String prompt) throws InputMismatchException {
        return input(prompt, STRING_TRUE);
    }

    // <editor-fold desc="loop">

    public static String inputLoop(String prompt, String failMessage, Predicate<String> condition) {
        while (true)
            try {
                return input(prompt, condition);
            } catch (InputMismatchException e) {
                System.out.println(failMessage);
            }
    }

    public static String inputLoop(String prompt, Predicate<String> condition) {
        return inputLoop(prompt, "", condition);
    }

    public static String inputLoop(String prompt, String failMessage) {
        return inputLoop(prompt, failMessage, STRING_TRUE);
    }

    public static String inputLoop(String prompt) {
        return inputLoop(prompt, "", STRING_TRUE);
    }

    public static String inputLoop(Predicate<String> condition) {
        return inputLoop("", "", condition);
    }

    public static String inputLoop() {
        return inputLoop("", "", STRING_TRUE);
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="inputInt()">

    public static int inputInt(String prompt, IntPredicate condition) throws NumberFormatException {
        int input = Integer.valueOf(input(prompt));
        if (!condition.test(input)) throw new NumberFormatException();
        return input;
    }

    public static int inputInt(IntPredicate condition) throws  NumberFormatException {
        return inputInt("", condition);
    }

    public static int inputInt(String prompt) throws NumberFormatException {
        return inputInt(prompt, INT_TRUE);
    }

    public static int inputInt() throws NumberFormatException {
        return inputInt("", INT_TRUE);
    }

    // <editor-fold desc="loop">

    public static int inputIntLoop(String prompt, String failMessage, IntPredicate condition) {
        while (true)
            try {
                return inputInt(prompt, condition);
            } catch (NumberFormatException e) {
                System.out.println(failMessage);
            }
    }

    public static int inputIntLoop(String prompt, IntPredicate condition) {
        return inputIntLoop(prompt, "", condition);
    }

    public static int inputIntLoop(String prompt, String failMessage) {
        return inputIntLoop(prompt, failMessage, INT_TRUE);
    }

    public static int inputIntLoop(String prompt) {
        return inputIntLoop(prompt, "", INT_TRUE);
    }

    public static int inputIntLoop(IntPredicate condition) {
        return inputIntLoop("", "", condition);
    }

    public static int inputIntLoop() {
        return inputIntLoop("", "", INT_TRUE);
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="Lambda Factories">

    public static <T> Predicate<T> conditions (Stream<Predicate<T>> stream) {
        return x -> stream.allMatch(condition -> condition.test(x));
    }

    public static <T> Predicate<T> conditions (Predicate<T>[] arr) {
        return conditions(Arrays.stream(arr));
    }

    public static <T> Predicate<T> conditions (Collection<Predicate<T>> collection) {
        return conditions(collection.stream());
    }


    public static IntPredicate inBounds (int lowerBound, int upperBound) {
        return x -> x >= lowerBound && x < upperBound;
    }

    public static IntPredicate inBounds (int upperBound) {
        return inBounds(1, upperBound);
    }


    public static final Predicate<String> IS_ALPHANUMERIC = matchesRegex("^[a-zA-Z0-9]+$");

    public static final Predicate<String> HAS_ONLY_LETTERS = matchesRegex("^[a-zA-Z]+$");

    public static Predicate<String> matchesRegex (Pattern pattern) {
        return x -> pattern.matcher(x).matches();
    }

    public static Predicate<String> matchesRegex (String regex, int flags) {
        return matchesRegex(Pattern.compile(regex, flags));
    }

    public static Predicate<String> matchesRegex (String regex) {
        return matchesRegex(regex, 0);
    }




    // </editor-fold>
}
