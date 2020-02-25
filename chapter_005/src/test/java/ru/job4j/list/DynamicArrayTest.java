package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {

    private DynamicArray<Integer> dynamicArray;

    @Before
    public void beforeTestAddElementDynamic() {
        dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
    }

    @Test
    public void whenGetFirstElementThenTwo() {
        assertThat(dynamicArray.get(1), is(2));
    }

    @Test
    public void whenGetTwoElementThenThree() {
        assertThat(dynamicArray.get(2), is(3));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> iter = dynamicArray.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> iter = dynamicArray.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        iter.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void thenAddFiveElementEndDynamicChangeThenThrowConcurrentModificationException() {
        Iterator<Integer> iter = dynamicArray.iterator();
        dynamicArray.add(4);
        dynamicArray.add(5);
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(5));
    }
}