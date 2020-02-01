package ru.job4j.generic;

import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    private SimpleArray<Integer> array = new SimpleArray<>(2);
    private Iterator<Integer> integerIterator = array.iterator();

    @Test
    public void whenCheckOperationMethodAdd() {
        array.add(100);
        int expected = 100;
        assertThat(array.get(0), is(expected));
    }

    @Test
    public void whenCheckOperationMethodGet() {
        array.add(100);
        int result = array.get(0);
        int expected = 100;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCheckOperationMethodRemove() {
        array.add(100);
        array.add(200);
        array.remove(0);
        int result = array.get(0);
        int expected = 200;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCheckOperationMethodSet() {
        array.add(100);
        array.add(200);
        array.set(0, 1000);
        int result = array.get(0);
        int expected = 1000;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCheckOperationMethodIterator() {
        array.add(100);
        array.add(200);
        Integer result1 = 100;
        Integer result2 = 200;
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(result1, is(integerIterator.next()));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(result2, is(integerIterator.next()));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorEmptyTest() {
        assertThat(integerIterator.hasNext(), is(false));
        integerIterator.next();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCheckOperationMethodAddEmptyTest() {
        array.add(100);
        array.add(200);
        array.add(300);
    }
}