package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.lists;

import com.codepoetics.protonpack.Streamable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@SuppressWarnings("WeakerAccess")
public class LinkedList <T> implements Streamable<T> {
    private Node headNode;
    public LinkedList(){}

    public LinkedList(LinkedList<T> list) {
        for (int index = 0; index < list.length(); index++) {
            this.append(list.get(index));
        }
    }


    // <editor-fold desc="List operations">

    public int length() {
        if (headNode == null) return 0;
        return headNode.size();
    }

    public void append(T elem) {
        if (headNode == null) headNode = new Node(elem);
        else headNode.append(elem);
    }

    public T get(int index) {
        try {
            if (index<0) throw new NullPointerException();
            return headNode.get(index);
        }
        catch (NullPointerException e) {
            throw outOfBounds(index);
        }
    }

    public void remove(int index) {
        try {
            if (index == 0) headNode = headNode.ref;
            headNode.remove(index);
        }
        catch (NullPointerException e) {
            throw outOfBounds(index);
        }
    }

    public int indexOf(T elem) {
        try {
            return headNode.indexOf(elem);
        }
        catch (NullPointerException e) {
            return -1;
        }
    }

    // </editor-fold>


    private IndexOutOfBoundsException outOfBounds(int i) {
        return new IndexOutOfBoundsException("list length is " + length() + ", index given is " + i);
    }


    // <editor-fold desc="Iteration tools">

    public LinkedListIterator iterator(){
        return new LinkedListIterator(this);
    }

    public Stream<T> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), 0), false);
    }

    // </editor-fold>


    // <editor-fold desc="Overrides">

    @Override
    public String toString() {
        return "[" + headNode.toString() + "]";
    }

    @Override
    public Stream<T> get() {
        return stream();
    }

    // </editor-fold>


    // <editor-fold desc="Custom classes">

    private class Node {
        T elem;
        Node ref;
        Node(T element) {
            elem = element;
        }

        int size() {
            return (ref == null ? 0 : ref.size()) + 1;
        }

        void append(T elem) {
            if (ref == null) ref = new Node(elem);
            else ref.append(elem);
        }

        @Override
        public String toString() {
            return elem.toString() + ", " + (ref == null ? "" : ref.toString());
        }

        T get(int index) {
            if (index == 0) return elem;
            return ref.get(index-1);
        }

        void remove(int index) {
            if (index == 1) ref = ref.ref;
            else ref.remove(index-1);
        }

        int indexOf(T elem) {
            if (elem == this.elem) return 0;
            return ref.indexOf(elem)+1;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        final LinkedList<T> list;
        int current = 0;
        LinkedListIterator(LinkedList<T> list) {
            this.list = new LinkedList<>(list);
        }


        @Override
        public boolean hasNext() {
            return current < list.length();
        }

        @Override
        public T next() {
            try {
                return list.get(current++);
            }
            catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }

    // </editor-fold>


    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<>();
        System.out.println(ls.length());
        ls.append(1);
        System.out.println(ls.length());
        Integer five = 5;
        ls.append(five);
        ls.append(3);
        System.out.println(ls.length());
        System.out.println(ls);
        System.out.println(ls.indexOf(five));
        ls.remove(1);
        System.out.println(ls);
    }
}
