package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayCharTest {

    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar arrayChar = new ArrayChar("Brother");
        boolean result = arrayChar.startWith("Broth");
        assertThat(result, is(true));
    }
    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayChar arrayChar = new ArrayChar("Brother");
        boolean result = arrayChar.startWith("Brath");
        assertThat(result, is(false));
    }
}