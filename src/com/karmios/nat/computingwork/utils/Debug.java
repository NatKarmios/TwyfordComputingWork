package com.karmios.nat.computingwork.utils;

@SuppressWarnings("unused")
public final class Debug {
    public static boolean print(boolean b) {
        System.out.println(b);
        return b;
    }

    public static byte print(byte b) {
        System.out.println(b);
        return b;
    }

    public static short print(short s) {
        System.out.println(s);
        return s;
    }

    public static char print(char c) {
        System.out.println(c);
        return c;
    }

    public static int print(int i) {
        System.out.println(i);
        return i;
    }

    public static long print(long l) {
        System.out.println(l);
        return l;
    }

    public static float print(float f) {
        System.out.println(f);
        return f;
    }

    public static double print(double d) {
        System.out.println(d);
        return d;
    }

    public static <T> T print(T t) {
        System.out.println(t);
        return t;
    }
}
