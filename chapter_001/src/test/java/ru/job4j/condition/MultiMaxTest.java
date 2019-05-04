package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MultiMaxTest {

    @Test
    public void whenFirstNumberMoreOthers() {
        MultiMax multiMax = new MultiMax();
        int result = multiMax.maxMulti(4, 3, 2);
        assertThat(result, is(4));
    }
}