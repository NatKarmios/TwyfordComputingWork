package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.queues;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.*;

class Cafeteria {
    private static AtomicInteger count = new AtomicInteger(0);
    private static Queue<String> queue;
    public static void main(String[] args) {
        queue = populateQueue();
        Till[] tills = {
                new Till(queue, 1000),
                new Till(queue, 1000),
                new Till(queue, 1000),
                new Till(queue, 2000)
        };
        System.out.println(" == Press enter to add a new student to the queue == ");
        Arrays.stream(tills).map(till -> till.thread).forEach(Thread::start);

        QueueAdder.start();

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

    private static Queue<String> populateQueue() {
        int numOfStudents;
        // numOfStudents = randInt(500, 750);
        numOfStudents = inputIntLoop("How many students start in the queue? => ",
                "Can't have a negative number of students!", x -> x>=0);
        Queue<String> queue = new Queue<>();
        IntStream.range(0, numOfStudents).forEach(x -> queue.put("(initial) "+count.getAndIncrement()));
        return queue;
    }

    // Daemon class for adding to the queue.
    private static class QueueAdder implements Runnable {
        Scanner sc;
        QueueAdder() {
            sc = new Scanner(System.in);
        }

        @Override
        public void run() {
            //noinspection InfiniteLoopStatement
            while (true) {
                sc.nextLine();
                queue.put("(post-init) "+count.getAndIncrement());
            }
        }

        private static void start() {
            Thread adderDaemonThread = new Thread(new QueueAdder());
            adderDaemonThread.setDaemon(true);
            adderDaemonThread.start();
        }
    }
}

class Till implements Runnable {
    private static transient AtomicInteger tillCount = new AtomicInteger(0);
    final int id;
    private final long waitTime;
    private Queue queue;

    final Thread thread;

    Till(Queue queue, long waitTime) {
        this.id = tillCount.getAndIncrement();
        this.queue = queue;
        this.waitTime = waitTime;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            Object student_id;
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