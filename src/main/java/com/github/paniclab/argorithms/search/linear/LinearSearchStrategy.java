package com.github.paniclab.argorithms.search.linear;

import com.github.paniclab.argorithms.search.SearchStrategy;

import java.util.Comparator;


public class LinearSearchStrategy<E> implements SearchStrategy<E> {
    @Override
    public int search(E element, E[] array) {
        final int NOT_FOUND = -1;
        int lastIndex = array.length - 1;
        E lastElement = array[lastIndex];

        array[lastIndex] = element;
        int index = 0;
        while (!array[index].equals(element)) {
            index++;
        }

        if(index < lastIndex) {
            return index;
        }
        if(lastElement.equals(element)) {
            return lastIndex;
        }

        return NOT_FOUND;
    }

    @Override
    public int search(E element, E[] array, Comparator<? super E> comparator) {
        final int NOT_FOUND = -1;
        int lastIndex = array.length - 1;
        E lastElement = array[lastIndex];

        array[lastIndex] = element;
        int index = 0;
        while (comparator.compare(array[index], element) != 0) {
            index++;
        }

        if(index < lastIndex) {
            return index;
        }
        if(lastElement.equals(element)) {
            return lastIndex;
        }

        return NOT_FOUND;
    }
}
