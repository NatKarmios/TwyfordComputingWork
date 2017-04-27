package com.karmios.nat.Encryption;


@java.lang.SuppressWarnings("SameParameterValue")
public class Caesar {
    public static void main(String[] args) {
        System.out.println(encrypt("aBc", 3));
    }

    private static String encrypt(String plainText, int shift){
        return plainText.chars().map(x -> {
            if(x >= 65 && x < 91) return (((x-65)+shift)%26)+65;
            if(x >= 97 && x < 113) return (((x-97)+shift)%26)+97;
            return x;
        }).mapToObj(x -> String.valueOf((char)x)).reduce("", (a, b) -> a+b);
    }
}
