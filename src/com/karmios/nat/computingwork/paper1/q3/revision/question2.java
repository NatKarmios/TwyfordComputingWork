package com.karmios.nat.computingwork.paper1.q3.revision;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class question2 {
    public static void main(String[] args) {
        int howFar = inputInt();
        while (howFar < 1) {
            System.out.println("Not a valid number, please try again.");
            howFar = inputInt();
        }

        for (int myLoop = 1; myLoop <= howFar; myLoop++)
            if(myLoop%3==0 && myLoop%5==0) System.out.println("FizzBuzz");
            else if (myLoop%3==0) System.out.println("Fizz");
            else if (myLoop%5==0) System.out.println("Buzz");
            else System.out.println(myLoop);
    }
}
