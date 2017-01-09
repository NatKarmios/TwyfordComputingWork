package com.karmios.nat.computingwork.utils;

import java.nio.file.FileSystems;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@SuppressWarnings({"WeakerAccess", "unused", "SameParameterValue"})
public final class Utils {
    private static final Scanner sc = new Scanner(System.in);
    public static final Random rng = new Random();

    public static String getClassDir(Class cls) {
        String sep = FileSystems.getDefault().getSeparator();
        return System.getProperty("user.dir") + sep + "src" + sep + cls.getPackage().getName().replace(".", sep) + sep;
    }


    // <editor-fold desc="Constant Predicates">

    public static final IntPredicate INT_TRUE = x -> true;

    public static final Predicate<String> STRING_TRUE = x -> true;

    public static final Predicate<String> IS_DATE = x -> {
        try {
            LocalDate.parse(x);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    };

    // </editor-fold>

    // <editor-fold desc="Inputs">

    // <editor-fold desc="input()">

    public static String input (String prompt, Predicate<String> condition) throws InputMismatchException {
        System.out.print(prompt);
        String input = sc.nextLine();
        if (!condition.test(input)) throw new InputMismatchException();
        return input;
    }

    public static String input (Predicate<String> condition) throws InputMismatchException {
        return input("> ", condition);
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
        return inputLoop(prompt, "> ", condition);
    }

    public static String inputLoop(String prompt, String failMessage) {
        return inputLoop(prompt, failMessage, STRING_TRUE);
    }

    public static String inputLoop(String prompt) {
        return inputLoop(prompt, "Invalid input!", STRING_TRUE);
    }

    public static String inputLoop(Predicate<String> condition) {
        return inputLoop("> ", "Invalid input!", condition);
    }

    public static String inputLoop() {
        return inputLoop("> ", "Invalid input!", STRING_TRUE);
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
        return inputInt("> ", condition);
    }

    public static int inputInt(String prompt) throws NumberFormatException {
        return inputInt(prompt, INT_TRUE);
    }

    public static int inputInt() throws NumberFormatException {
        return inputInt("> ", INT_TRUE);
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
        return inputIntLoop(prompt, "Invalid input!", condition);
    }

    public static int inputIntLoop(String prompt, String failMessage) {
        return inputIntLoop(prompt, failMessage, INT_TRUE);
    }

    public static int inputIntLoop(String prompt) {
        return inputIntLoop(prompt, "Invalid input!", INT_TRUE);
    }

    public static int inputIntLoop(IntPredicate condition) {
        return inputIntLoop("> ", "Invalid input!", condition);
    }

    public static int inputIntLoop() {
        return inputIntLoop("> ", "Invalid input!", INT_TRUE);
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="inputBool()">

    public static boolean inputBool(String prompt, boolean addYN) throws InputMismatchException {
        if (addYN) {
            if (prompt.endsWith(": "))
                prompt = prompt.substring(0, prompt.length() - 2) + " (Y/N)" + ": ";
            else
                prompt = prompt + "(Y/N) ";
        }
        System.out.print(prompt);
        String input = sc.nextLine().trim().toUpperCase();
        if (input.startsWith("Y") || input.startsWith("N")) return input.startsWith("Y");
        else throw new InputMismatchException();
    }

    public static boolean inputBool(String prompt) throws InputMismatchException {
        return inputBool(prompt, false);
    }

    public static boolean inputBool(boolean addYN) {
        return inputBool("> ", addYN);
    }

    public static boolean inputBool() {
        return inputBool("> ", false);
    }

    // <editor-fold desc="loop">

    public static boolean inputBoolLoop(String prompt, String failMessage, boolean addYN) {
        while (true) {
            try {
                return inputBool(prompt, addYN);
            }
            catch (InputMismatchException e) {
                System.out.println(failMessage);
            }
        }
    }

    public static boolean inputBoolLoop(String prompt, String failMessage) {
        return inputBoolLoop(prompt, failMessage, false);
    }

    public static boolean inputBoolLoop(String prompt, boolean addYN) {
        return inputBoolLoop(prompt, "Invalid input!");
    }

    public static boolean inputBoolLoop(String prompt) {
        return inputBoolLoop(prompt, "Invalid input!", false);
    }

    public static boolean inputBoolLoop(boolean addYN) {
        return inputBoolLoop("> ", "Invalid input!", addYN);
    }

    public static boolean inputBoolLoop() {
        return inputBoolLoop("> ", "Invalid input!", false);
    }

    // </editor-fold>

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="Lambda Factories">

    // <editor-fold desc="matchesAll()">

    public static <T> Predicate<T> matchesAll (Stream<Predicate<T>> stream) {
        return x -> stream.allMatch(condition -> condition.test(x));
    }

    @SafeVarargs
    public static <T> Predicate<T> matchesAll (Predicate<T>... arr) {
        return matchesAll(Arrays.stream(arr));
    }

    public static <T> Predicate<T> matchesAll (Collection<Predicate<T>> collection) {
        return matchesAll(collection.stream());
    }

    // </editor-fold>

    // <editor-fold desc="matchesAny()">

    public static <T> Predicate<T> matchesAny (Stream<Predicate<T>> stream) {
        return x -> stream.anyMatch(condition -> condition.test(x));
    }

    @SafeVarargs
    public static <T> Predicate<T> matchesAny (Predicate<T>... arr) {
        return matchesAny(Arrays.stream(arr));
    }

    public static <T> Predicate<T> matchesAny (Collection<Predicate<T>> collection) {
        return matchesAny(collection.stream());
    }

    // </editor-fold>

    public static <T> Predicate<T> runsCleanly (Predicate<T> condition) {
        return t -> {
            try {
                return condition.test(t);
            }
            catch (Exception e) {
                return false;
            }
        };
    }

    public static <T> Predicate<T> runsCleanly (Consumer<T> consumer) {
        return t -> {
            try {
                consumer.accept(t);
                return true;
            }
            catch (Exception e) {
                return false;
            }
        };
    }

    // <editor-fold desc="Int Checkers">

    public static IntPredicate inBounds (int lowerBound, int upperBound) {
        return x -> x >= lowerBound && x < upperBound;
    }

    public static IntPredicate inBounds (int upperBound) {
        return inBounds(1, upperBound);
    }

    // <editor-fold desc="Simple Comparators">

    public static IntPredicate lessThan (int val) {
        return x -> x < val;
    }

    public static IntPredicate greaterThan (int val) {
        return x -> x > val;
    }

    public static IntPredicate atMost (int val) {
        return x -> x <= val;
    }

    public static IntPredicate atLeast (int val) {
        return x -> x <= val;
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="Regex"

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

    // </editor-fold>

    public interface RunnableWithException <E extends Throwable> {
        void run() throws E;
    }

    public interface SupplierWithException <T, E extends Throwable> {
        T get() throws E;
    }

    public interface FunctionWithException <T, R, E extends Throwable> {
        R apply(T t) throws E;
    }
}
