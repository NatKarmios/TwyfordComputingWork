package com.karmios.nat.computingwork.utils;

import java.nio.file.FileSystems;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@SuppressWarnings({"WeakerAccess", "unused", "SameParameterValue"})
public final class Utils {

    // <editor-fold desc="Often-Used Single Instances">

    private static final Scanner sc = new Scanner(System.in);
    public static final Random rng = new Random();

    // </editor-fold>

    // <editor-fold desc="Misc Functions">

    public static String getClassDir(Class cls) {
        String sep = FileSystems.getDefault().getSeparator();
        return System.getProperty("user.dir") + sep + "src" + sep + cls.getPackage().getName().replace(".", sep) + sep;
    }

    // <editor-fold desc="randInt()">

    public static int randInt(int lowerBound, int upperBound) {
        return rng.nextInt(upperBound-lowerBound) + lowerBound;
    }

    public static int randInt(int upperBound) {
        return randInt(0, upperBound);
    }

    // </editor-fold>

    // <editor-fold desc="sorted()">

    public static <T, L extends ArrayList<T>> ArrayList<T> sorted(L l, Comparator<T> comparator) {
        ArrayList<T> l2 = new ArrayList<>(l);
        l2.sort(comparator);
        return l2;
    }

    public static <T extends Comparable<? super T>, L extends ArrayList<T>> ArrayList<T> sorted(L l, boolean reverse) {
        return sorted(l, reverse ? Comparator.reverseOrder() : Comparator.naturalOrder());
    }

    public static <T extends Comparable<? super T>, L extends ArrayList<T>> ArrayList<T> sorted(L l) {
        return sorted(l, false);
    }

    // </editor-fold>
    
    public int mutateUntil(int x, IntUnaryOperator operator, IntPredicate condition) {
        while (!condition.test(x)) x = operator.applyAsInt(x);
        return x;
    }

    public long mutateUntil(long x, LongUnaryOperator operator, LongPredicate condition) {
        while (!condition.test(x)) x = operator.applyAsLong(x);
        return x;
    }
    
    public double mutateUntil(double x, DoubleUnaryOperator operator, DoublePredicate condition) {
        while (!condition.test(x)) x = operator.applyAsDouble(x);
        return x;
    }

    public <X> X mutateUntil(X x, UnaryOperator<X> operator, Predicate<X> condition) {
        while (!condition.test(x)) x = operator.apply(x);
        return x;
    }

    // </editor-fold>

    // <editor-fold desc="Constant Predicates">

    public static final IntPredicate INT_TRUE = x -> true;
    
    public static final DoublePredicate DOUBLE_TRUE = x -> true;

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

    public static final IntPredicate IS_NATURAL = x -> x > 0;

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

    // <editor-fold desc="inputDouble()">

    public static double inputDouble(String prompt, DoublePredicate condition) throws NumberFormatException {
        double input = Double.valueOf(input(prompt));
        if (!condition.test(input)) throw new NumberFormatException();
        return input;
    }

    public static double inputDouble(DoublePredicate condition) throws  NumberFormatException {
        return inputDouble("> ", condition);
    }

    public static double inputDouble(String prompt) throws NumberFormatException {
        return inputDouble(prompt, DOUBLE_TRUE);
    }

    public static double inputDouble() throws NumberFormatException {
        return inputDouble("> ", DOUBLE_TRUE);
    }

    // <editor-fold desc="loop">

    public static double inputDoubleLoop(String prompt, String failMessage, DoublePredicate condition) {
        while (true)
            try {
                return inputDouble(prompt, condition);
            } catch (NumberFormatException e) {
                System.out.println(failMessage);
            }
    }

    public static double inputDoubleLoop(String prompt, DoublePredicate condition) {
        return inputDoubleLoop(prompt, "Invalid input!", condition);
    }

    public static double inputDoubleLoop(String prompt, String failMessage) {
        return inputDoubleLoop(prompt, failMessage, DOUBLE_TRUE);
    }

    public static double inputDoubleLoop(String prompt) {
        return inputDoubleLoop(prompt, "Invalid input!", DOUBLE_TRUE);
    }

    public static double inputDoubleLoop(DoublePredicate condition) {
        return inputDoubleLoop("> ", "Invalid input!", condition);
    }

    public static double inputDoubleLoop() {
        return inputDoubleLoop("> ", "Invalid input!", DOUBLE_TRUE);
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
        return inputBoolLoop(prompt, "Invalid input!", addYN);
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
            catch (Throwable e) {
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
            catch (Throwable e) {
                return false;
            }
        };
    }

    // <editor-fold desc="Int Checkers">

    public static IntPredicate inBounds (int lowerBound, int upperBound) {
        return x -> x >= lowerBound && x < upperBound;
    }

    public static IntPredicate inBounds (int upperBound) {
        return inBounds(0, upperBound);
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

    // <editor-fold desc="Functional Interfaces">

    @FunctionalInterface
    public interface ERunnable <E extends Throwable> {
        void run() throws E;
    }

    @FunctionalInterface
    public interface ESupplier <T, E extends Throwable> {
        T get() throws E;
    }

    @FunctionalInterface
    public interface EFunction <T, R, E extends Throwable> {
        R apply(T t) throws E;
    }

    @FunctionalInterface
    public interface EConsumer <T, E extends Throwable> {
        void accept(T t) throws E;
    }

    // </editor-fold>

}
