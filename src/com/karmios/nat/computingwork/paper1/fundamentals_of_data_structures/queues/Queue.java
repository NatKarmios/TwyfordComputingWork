package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.queues;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("WeakerAccess")
public class Queue <E> {
    @Nullable
    private Node headNode, tailNode;

    private AtomicInteger size = new AtomicInteger(0);

    public synchronized void put (@NotNull E e) {
        if (e == null) throw new IllegalArgumentException();
        try {
            tailNode = (tailNode.ref = new Node(e));
        } catch (NullPointerException _e) {
            headNode = new Node(e);
            tailNode = headNode;
        }
        size.getAndIncrement();
    }

    public synchronized E get () {
        try {
            E e = headNode.elem;
            headNode = headNode.ref;
            size.getAndDecrement();
            return e;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public int size() {
        return size.get();
    }

    private class Node {
        E elem;
        Node ref;
        Node(E element) {
            elem = element;
        }


    }
}
