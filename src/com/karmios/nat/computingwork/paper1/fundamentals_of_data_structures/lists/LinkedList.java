package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.lists;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.codepoetics.protonpack.StreamUtils.zipWithIndex;

@SuppressWarnings("WeakerAccess")
public class LinkedList <T> implements Collection<T>, Runnable {
    private Node headNode;
    public LinkedList(){}

    public LinkedList(LinkedList<T> list) {
        for (int index = 0; index < list.size(); index++) {
            this.add(list.get(index));
        }
    }


    // <editor-fold desc="Collection operations">

    public int size() {
        if (headNode == null) return 0;
        return headNode.size();
    }

    public boolean add(T elem) {
        if (headNode == null) headNode = new Node(elem);
        else headNode.append(elem);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object o) {
        try {
            remove(indexOf((T) o));
            return true;
        }
        catch (ClassCastException e) {
            return false;
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        final AtomicBoolean found = new AtomicBoolean(true);
        c.forEach(x -> found.set(contains(x) && found.get()));
        return found.get();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        final AtomicBoolean changed = new AtomicBoolean(false);
        c.forEach(x -> changed.set(add(x) || changed.get()));
        return changed.get();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        final AtomicBoolean changed = new AtomicBoolean(false);
        c.forEach(x -> changed.set(remove(x) || changed.get()));
        return changed.get();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        AtomicBoolean changed = new AtomicBoolean(false);
        forEach(t -> changed.set(contains(c) ? remove(c) || changed.get() : changed.get()));
        return changed.get();
    }

    @Override
    public void clear() {
        while (headNode != null) remove(0);
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
            if (index < 0) throw new NullPointerException();
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

    public boolean isEmpty() {
        return headNode == null;
    }

    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        try {
            return indexOf((T) o) > -1;
        }
        catch (ClassCastException e) {
            return false;
        }
    }

    // </editor-fold>


    private IndexOutOfBoundsException outOfBounds(int i) {
        return new IndexOutOfBoundsException("list size is " + size() + ", index given is " + i);
    }


    // <editor-fold desc="Iteration tools">

    public LinkedListIterator iterator(){
        return new LinkedListIterator(this);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        zipWithIndex(stream()).forEach(item -> arr[(int)item.getIndex()] = item.getValue());
        return arr;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <X> X[] toArray(X[] a) {
        X[] arr = a.length >= size() ? a : (X[])new Object[size()];
        zipWithIndex(stream()).forEach(item -> arr[(int)item.getIndex()] = (X)item.getValue());
        return arr;
    }

    public Stream<T> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), 0), false);
    }

    public T firstMatch(Predicate<T> condition) {
        for (T elem : this) {
            if (condition.test(elem)) return elem;
        }
        throw new NoSuchElementException();
    }

    // </editor-fold>


    // <editor-fold desc="Overrides">

    @Override
    public String toString() {
        return "[" + headNode.toString() + "]";
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
            if (elem.equals(this.elem)) return 0;
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
            return current < list.size();
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
        new LinkedList<>().run();
    }

    public void run() {
        LinkedList<Integer> ls = new LinkedList<>();
        System.out.println(ls.size());
        ls.add(1);
        System.out.println(ls.size());
        Integer five = 5;
        ls.add(five);
        ls.add(3);
        System.out.println(ls.size());
        System.out.println(ls);
        System.out.println(ls.indexOf(five));
        ls.remove(1);
        System.out.println(ls);
    }
}
