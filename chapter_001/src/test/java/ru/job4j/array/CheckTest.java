package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckTest {

    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean expect = check.mono(new boolean[] {true, true, true});
        assertThat(true, is(expect));
    }
    @Test
    public void whenDataMonoByTrueThenFalse() {
        Check check = new Check();
        boolean expect = check.mono(new boolean[] {true, false, true});
        assertThat(false, is(expect));
    }
}