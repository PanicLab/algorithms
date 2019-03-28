package com.github.paniclab.argorithms.search.binary;

import com.github.paniclab.argorithms.search.SearchStrategy;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Comparator;


public class BinarySearchStrategy<E> implements SearchStrategy<E> {
    @Override
    public int search(E element, E[] array) {
        throw new RuntimeException("Operation is not supported");
    }


    @Override
    public int search(E element, E[] array, Comparator<? super E> comparator) {
        final int NOT_FOUND = -1;
        int leftLimit = 0;
        int rightLimit = array.length - 1;

        int middle = (leftLimit + rightLimit)/2;

        E middleElement = array[middle];
        if(comparator.compare(middleElement, element) == 0) {
            return middle;
        }

        if(comparator.compare(middleElement, element) < 0) {
            rightLimit = middle - 1;
            E[] newArray = (E[]) Arrays.asList(array).subList(leftLimit, rightLimit).toArray();
            return search(element, newArray, comparator);
        }

        if(comparator.compare(middleElement, element) > 0) {
            leftLimit = middle + 1;
            E[] newArray = (E[]) Arrays.asList(array).subList(leftLimit, rightLimit).toArray();
            return search(element, newArray, comparator);
        }

        return NOT_FOUND;
    }
}
