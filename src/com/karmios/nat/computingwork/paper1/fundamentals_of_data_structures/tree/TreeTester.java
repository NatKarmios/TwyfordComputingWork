package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.tree;

import java.util.Comparator;

public class TreeTester {
    public static void main(String[] args) {
        StringWrapperFactory wrapperFactory = new StringWrapperFactory((str1, str2) ->
            Character.compare(str1.toLowerCase().charAt(0), str2.toLowerCase().charAt(0))
        );

        BinaryTree<StringWrapper> tree = new BinaryTree<>();
        for(String str : new String[]{
                "hi", "Hello world!", "apple", "amazon", "asmodeus", "Hey there!", "lad", "lanky"
        })
            tree.add(wrapperFactory.make(str));

        System.out.println(tree.size());
        System.out.println(tree.get(wrapperFactory.make("homogenous")));
    }
}

class StringWrapper implements Comparable<StringWrapper>{
    public final String str;
    private final Comparator<String> comparator;

    StringWrapper(String str, Comparator<String> comparator) {
        this.str = str;
        this.comparator = comparator;
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public int compareTo(StringWrapper o) {
        return comparator.compare(str, o.str);
    }
}

class StringWrapperFactory {
    private final Comparator<String> comparator;

    StringWrapperFactory(Comparator<String> comparator) {
        this.comparator = comparator;
    }

    StringWrapper make(String str) {
        return new StringWrapper(str, comparator);
    }
}