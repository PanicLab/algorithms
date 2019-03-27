package com.github.paniclab.argorithms.search.linear;

import com.github.paniclab.argorithms.search.SearchStrategy;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.IntPredicate;


public class LinearSearchStrategy<E, C extends Collection<E>> implements SearchStrategy<E, C> {
    @Override
    public int search(E element, E[] array) {
        IntPredicate comparePredicate = null;
        if(Comparable.class.isAssignableFrom(element.getClass())) {
            comparePredicate = index -> {
                Comparable<E> e = (Comparable<E>) element;

                return e.compareTo(array[index]) == 0;
            };
        } else {
            comparePredicate = index -> array[index].equals(element);
        }
        return search(element, array, comparePredicate);
    }



    private int search(E element, E[] array, IntPredicate compare) {
        int lastIndex = array.length - 1;
        E lastElement = array[lastIndex];

        array[lastIndex] = element;
        int index = 0;
        while (compare.negate().test(index)) {
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

    @Override
    public int search(E element, C collection, Comparator<? super E> comparator) {
        E[] array = (E[]) collection.toArray();
        IntPredicate comparePredicate = index -> comparator.compare(array[index], element) == 0;
        return search(element, array, comparePredicate);
    }
}
