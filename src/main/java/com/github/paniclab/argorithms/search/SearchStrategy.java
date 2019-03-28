package com.github.paniclab.argorithms.search;


import java.util.Comparator;

public interface SearchStrategy<E> {

    int search(E element, E[] array);
    int search(E element, E[] array, Comparator<? super E> comparator);
}
