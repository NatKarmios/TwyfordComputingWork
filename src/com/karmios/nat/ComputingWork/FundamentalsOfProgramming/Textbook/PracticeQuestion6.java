package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Textbook;
public class PracticeQuestion6 {
    private static Object[] queue = new Object[9];
    private static int front = 0;
    private static int rear = 3;

    static void AddAndRemove(Object DataItem) {
        rear--;
        if (rear == 9) rear = 0;
        queue[rear] = DataItem;

        queue[front] = null;
        front++;
        if (front == 9) front = 0;
    }

    public static Object[] getQueue () {
        return queue.clone();
    }
}
