package com.github.paniclab.argorithms.search;

import java.util.Collection;
import java.util.Comparator;


public interface SearchStrategy<E, C extends Collection<E>> {

    int search(E element, E[] array);
    @SuppressWarnings("unchecked")
    default int search(E element, C collection) {
        E[] array = (E[]) collection.toArray();
        return search(element, array);
    }


    int search(E element, C collection, Comparator<? super E> comparator);
}
