package com.github.paniclab.argorithms.search.linear;

import com.github.paniclab.argorithms.search.SearchStrategy;

import java.util.Collection;
import java.util.function.BiFunction;

public class LinearSearchStrategy<E, C extends Collection<E>> implements SearchStrategy<E, C> {
    private BiFunction<E, E[], Integer> searchFunction = this::applyFunction;

    @Override
    public int search(E element, E[] array) {
        return searchFunction.apply(element, array);
    }


    private int applyFunction(E element, E[] array) {
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
        return -1;
    }
}
