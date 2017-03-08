package com.karmios.nat.computingwork.paper1.q3.revision;

public class question3 {
    @SuppressWarnings("StringEquality")
    public static void main(String[] args) {
        System.out.println("The first few prime numbers are:");
        for (int count1=2; count1<=50; count1++) {
            int count2 = 2;
            String prime = "Yes";
            while (count2*count2 <= count1) if (count1 % count2++ == 0) prime = "No";
            if (prime == "Yes") System.out.println(count1);
        }
    }
}
