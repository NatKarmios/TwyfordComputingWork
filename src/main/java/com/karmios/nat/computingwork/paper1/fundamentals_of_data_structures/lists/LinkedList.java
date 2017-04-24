package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.lists;

//TODO FINISH

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.codepoetics.protonpack.StreamUtils.zipWithIndex;

@SuppressWarnings({"WeakerAccess", "ConstantConditions"})
public class LinkedList <T> implements List<T>, Runnable {
    private Node headNode;
    public LinkedList(){}

    public LinkedList(LinkedList<T> list) {
        this.addAll(list);
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
            remove(indexOf(o));
            return true;
        }
        catch (ClassCastException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        final AtomicBoolean found = new AtomicBoolean(true);
        c.forEach(x -> found.set(contains(x) && found.get()));
        return found.get();
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        final AtomicBoolean changed = new AtomicBoolean(false);
        c.forEach(x -> changed.set(add(x) || changed.get()));
        return changed.get();
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        final AtomicBoolean changed = new AtomicBoolean(false);
        c.forEach(x -> changed.set(remove(x) || changed.get()));
        return changed.get();
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
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

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    public T remove(int index) {
        try {
            if (index < 0) throw new NullPointerException();
            if (index == 0) headNode = headNode.ref;
            return headNode.remove(index);
        }
        catch (NullPointerException e) {
            throw outOfBounds(index);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public int indexOf(Object o) {
        try {
            return headNode.indexOf((T) o);
        }
        catch (NullPointerException | ClassCastException e) {
            return -1;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public int lastIndexOf(Object o) {
        try {
            return headNode.lastIndexOf((T) o, -1, 0);
        }
        catch (NullPointerException | ClassCastException e) {
            return -1;
        }
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public boolean contains(Object o) {
        try {
            return indexOf(o) > -1;
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

    @NotNull
    public LinkedListIterator iterator(){
        return new LinkedListIterator(this);
    }

    @NotNull
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        zipWithIndex(stream()).forEach(item -> arr[(int)item.getIndex()] = item.getValue());
        return arr;
    }

    @NotNull
    @SuppressWarnings("unchecked")
    @Override
    public <X> X[] toArray(@NotNull X[] a) {
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

        T remove(int index) {
            if (index == 1) {
                T result = ref.elem;
                ref = ref.ref;
                return result;
            }
            else return ref.remove(index-1);
        }

        int indexOf(T elem) {
            if (elem.equals(this.elem)) return 0;
            return ref.indexOf(elem)+1;
        }

        int lastIndexOf(T elem, int last, int i) {
            if (elem.equals(this.elem)) last = i;
            if (ref == null) return last;
            return ref.lastIndexOf(elem, last, i+1);
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

    @SuppressWarnings("unused")
    private class LinkedListListIterator implements ListIterator<T> {
        private LinkedList<T> ls;
        private int i = 0;
        private Boolean next = null;
        public LinkedListListIterator(LinkedList<T> ls) {
            this(ls, 0);
        }

        public LinkedListListIterator(LinkedList<T> ls, int i) {
            this.ls = ls;
            this.i = i;
        }

        @Override
        public boolean hasNext() {
            return i < ls.size()-1;
        }

        @Override
        public T next() {
            return ls.get(i++);
        }

        @Override
        public boolean hasPrevious() {
            return i > 0;
        }

        @Override
        public T previous() {
            return ls.get((i--)-1);
        }

        @Override
        public int nextIndex() {
            return i;
        }

        @Override
        public int previousIndex() {
            return i-1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

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

