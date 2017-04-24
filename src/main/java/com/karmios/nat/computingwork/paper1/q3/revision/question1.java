package com.karmios.nat.computingwork.paper1.q3.revision;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class question1 {
    public static void main(String[] args) {
        int num = inputIntLoop("Enter a decimal number: ", "You must enter an integer greater than 0!", x -> x > 0);
        StringBuilder result = new StringBuilder();

        for(int i=num; i>0; i/=2)
            if (i%2==1) result.append(1);
            else result.append(0);

        System.out.printf("%s in binary is %s", num, result);
    }
}
