package com.karmios.nat.computingwork.ocr_challenges;

import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;
import static com.karmios.nat.computingwork.utils.Utils.randInt;

public class Challenge08_ArithmeticTest {
    public static void main(String[] args) {
        System.out.println("  == Welcome to the Arithmetic Test! ==\n" +
                           "  ==    [ Truncate all decimals ]    ==");
        int score = 0;
        for (int i = 0; i < 10; i++) if (Question.ask(i+1)) score++;
        System.out.printf("\n  == Final Score: %s/10 ==\n", score);
    }
}

class Question {
    private enum Operator {
        ADD('+'), SUB('-'), MUL('×'), DIV('÷');

        final char sign;
        Operator(char sign) {
            this.sign = sign;
        }
    }
    private final Operator operator;
    private final int num1, num2, answer;

    private Question(Operator operator, int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;

        switch (operator) {
            case ADD:
                answer = num1+num2;
                break;
            case SUB:
                answer = num1-num2;
                break;
            case MUL:
                answer = num1*num2;
                break;
            case DIV:
                answer = num1/num2;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private Question() {
        this(Operator.values()[randInt(4)],
                randInt(-12, 12), randInt(-12, 12));
    }

    @SuppressWarnings("WeakerAccess")
    static boolean ask() {
        Question q = new Question();
        if (inputIntLoop(String.format("\n%s %s %s = ", q.num1, q.operator.sign, q.num2),
                "You must enter a number!") == q.answer) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("Wrong - the correct answer was %s.\n", q.answer);
            return false;
        }
    }

    static boolean ask(int questionNumber) {
        System.out.printf("\nQuestion %s:", questionNumber);
        return ask();
    }
}