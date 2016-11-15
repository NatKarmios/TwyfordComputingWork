package com.karmios.nat.computingwork.assessments.q1;

public class OneToFifty {
    public static void main(String[] args) {
        for(int i=1; i<=50; i++) {
            if(i%5==0) System.out.println("HiFive");
            else if(i%2==0) System.out.println("HiTwo");
            else if(i%3==0 || i%7==0) System.out.println("HiThreeOrSeven");
            else System.out.println(i);
        }
    }
}
