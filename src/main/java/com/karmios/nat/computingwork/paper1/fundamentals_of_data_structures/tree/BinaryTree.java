package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@SuppressWarnings("WeakerAccess")
public class BinaryTree <T extends Comparable<T>> {
    private Node rootNode;
    private int size = 0;

    public void add(T elem) {
        if (rootNode == null) rootNode = new Node(elem);
        else rootNode.add(elem);
        size++;
    }

    public ArrayList<T> get(T val) throws NoSuchElementException {
        if (rootNode == null) throw new NoSuchElementException();
        return rootNode.get(val);
    }

    public int size() {
        return size;
    }

    private class Node {
        ArrayList<T> elems;
        Node leftChild, rightChild;

        private Node(T elem) {
            this.elems = new ArrayList<>();
            this.elems.add(elem);
        }

        private void add(T elem) {
            switch (Integer.signum(this.elems.get(0).compareTo(elem))) {
                // New element is larger
                case -1:
                    if (rightChild != null)
                        rightChild.add(elem);
                    else
                        rightChild = new Node(elem);
                    break;

                // New element is equal
                case 0:
                    elems.add(elem);
                    break;

                // New element is smaller
                case 1:
                    if (leftChild != null)
                        leftChild.add(elem);
                    else
                        leftChild = new Node(elem);
                    break;
            }
        }

        private ArrayList<T> get(T val) throws NoSuchElementException {
            switch (Integer.signum(this.elems.get(0).compareTo(val))) {
                // Requested elements are larger
                case -1:
                    if (rightChild == null) throw new NoSuchElementException();
                    return rightChild.get(val);

                // Requested elements are equal
                case 0:
                    return elems;

                // Requested elements are smaller
                case 1:
                    if (leftChild == null) throw new NoSuchElementException();
                    return rightChild.get(val);

                default:
                    throw new NoSuchElementException();
            }
        }
    }
}
