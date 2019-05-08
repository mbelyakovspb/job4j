package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int result = findLoop.indexOf(input, 5);
        assertThat(result, is(0));
    }
}