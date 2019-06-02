package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenNumberTwoAndOneThenTwoMore() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }
}