package com.github.paniclab.argorithms.search.binary;

import com.github.paniclab.argorithms.search.SearchStrategy;

import java.util.Collection;

public class BinarySearchStrategy<E, C extends Collection<E>> implements SearchStrategy<E, C> {


    @Override
    public int search(E element, E[] array) {
        return applyFunction(element, array);
    }

    private int applyFunction(E element, E[] array) {
        int leftLimit = 0;
        int rightLimit = array.length - 1;

        int middle = (leftLimit + rightLimit)/2;

        if(array[middle].equals(element)) {
            return middle;
        }

        if()
    }
}
