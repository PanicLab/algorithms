package com.github.paniclab.argorithms.search.binary;

import com.github.paniclab.argorithms.search.SearchStrategy;
import com.github.paniclab.argorithms.search.linear.LinearSearchStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class BinarySearchStrategyTest {
    private final int ARRAY_SIZE = 10;

    private SearchStrategy<Integer> searchStrategy = new BinarySearchStrategy<>();
    private List<Integer> elements;
    private final Integer WANTED = 1001;

    @Before
    public void setUp() throws Exception {
        elements = IntStream.range(1, ARRAY_SIZE).boxed().collect(Collectors.toList());
        elements.add(WANTED);

        Collections.sort(elements);
    }

    @After
    public void tearDown() throws Exception {
        elements.clear();
    }

    @Test
    public void search() {
        Integer[] array = new Integer[elements.size()];
        array = elements.toArray(array);
        int position = searchStrategy.search(WANTED, array);

        for (int i=0; i < ARRAY_SIZE; i++  ) {
            System.out.println(i + ": " + array[i]);
        }

        System.out.println("Index=" + position);
    }
}