package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.queues;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class Cafeteria {
    public static void main(String[] args) {
        Queue<Integer> queue = populateQueue();
        Till[] tills = {
                new Till(queue, 1000),
                new Till(queue, 1000),
                new Till(queue, 1000),
                new Till(queue, 2000)
        };

        Arrays.stream(tills).map(till -> till.thread).forEach(Thread::start);
        Arrays.stream(tills).forEach(till -> {
            try {
                till.thread.join();
            } catch (InterruptedException e) {
                System.err.printf("Waiting for till %s was interrupted!\n", till.id);
            }
        });
        System.out.println("All tills finished.");
        System.out.printf("Queue size: %s\n", queue.size());
    }

    private static Queue<Integer> populateQueue() {
        int numOfStudents = randInt(500, 750);
        Queue<Integer> queue = new Queue<>();
        IntStream.range(0, numOfStudents).forEach(queue::put);
        return queue;
    }
}

class Till implements Runnable {
    private static transient AtomicInteger tillCount = new AtomicInteger(0);
    final int id;
    private final long waitTime;
    private Queue<Integer> queue;

    final Thread thread;

    Till(Queue<Integer> queue, long waitTime) {
        this.id = tillCount.getAndIncrement();
        this.queue = queue;
        this.waitTime = waitTime;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            Integer student_id;
            while ((student_id = queue.get()) != null) {
                Thread.sleep(waitTime);
                System.out.printf(" Till %s served student %s.\n", id, student_id);
            }
        }
        catch (InterruptedException e) {
            System.err.printf("Till %s was interrupted!\n", id);
        }
        System.out.printf("Till %s has run out of students.\n", id);
    }
}